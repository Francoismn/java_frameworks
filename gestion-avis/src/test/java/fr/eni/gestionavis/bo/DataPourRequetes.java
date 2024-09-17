package fr.eni.gestionavis.bo;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.eni.gestionavis.bo.Avis;
import fr.eni.gestionavis.bo.Client;
import fr.eni.gestionavis.dal.AvisRepository;
import fr.eni.gestionavis.dal.BouteilleRepository;

@SpringBootTest
class DataPourRequetes {

	@Autowired
	BouteilleRepository bouteilleRepository;

	@Autowired
	AvisRepository avisRepository;

	// Vider la collection de bouteilles
	void vider_Bouteilles_DB() {
		bouteilleRepository.deleteAll();  // Supprime toutes les bouteilles de la collection
		System.out.println("Collection 'bottles' vidée.");
	}

	// Vider la collection d'avis
	void vider_Avis_DB() {
		avisRepository.deleteAll();  // Supprime tous les avis de la collection
		System.out.println("Collection 'avis' vidée.");
	}

	// Insérer des bouteilles dans la base
	void insertion_Bouteille_DB() {
		final List<Bouteille> listeBouteilles = new ArrayList<>();

		// Création de 3 Bouteilles
		listeBouteilles.add(Bouteille
				.builder()
				.id(BouteilleId
						.builder()
						.idBouteille(18298)
						.idRegion(3)
						.idCouleur(1)
						.build())
				.nom("Vin ENI Edition")
				.build());

		listeBouteilles.add(Bouteille
				.builder()
				.id(BouteilleId
						.builder()
						.idBouteille(1298)
						.idRegion(3)
						.idCouleur(2)
						.build())
				.nom("Vin ENI Service")
				.build());

		listeBouteilles.add(Bouteille
				.builder()
				.id(BouteilleId
						.builder()
						.idBouteille(1999)
						.idRegion(2)
						.idCouleur(3)
						.build())
				.nom("Vin ENI Ecole")
				.build());

		// Sauvegarder les bouteilles dans la base
		listeBouteilles.forEach(b -> {
			bouteilleRepository.save(b);
		});
	}

	// Insérer des avis dans la base
	void insertion_Avis_DB() {
		// Récupération depuis la base des Bouteilles
		final List<Bouteille> listeBouteilles = bouteilleRepository.findAll();
		assertThat(listeBouteilles).isNotNull();
		assertThat(listeBouteilles).isNotEmpty();
		assertThat(listeBouteilles.size()).isEqualTo(3);

		// Liste de Clients
		final List<Client> listeClients = new ArrayList<>();
		listeClients.add(Client
				.builder()
				.pseudo("bobeponge@email.fr")
				.quantiteCommandee(11)
				.build());
		listeClients.add(Client
				.builder()
				.pseudo("patricketoile@email.fr")
				.quantiteCommandee(12)
				.build());
		listeClients.add(Client
				.builder()
				.pseudo("carlotentacule@email.fr")
				.quantiteCommandee(25)
				.build());

		// Ajout d'Avis par Client sur chaque Bouteille
		int note = 2;  // Note initiale

		for (Client c : listeClients) {
			// Faire varier la date :
			LocalDateTime ldf = LocalDateTime.of(2023, 7, 13, 15, 28);

			for (int i = 0; i < listeBouteilles.size(); i++) {
				final Bouteille b = listeBouteilles.get(i);

				// Faire varier la quantite du Client selon la note
				c.setQuantiteCommandee(c.getQuantiteCommandee() * note);

				final Avis avis = Avis
						.builder()
						.note(note)
						.commentaire("Commentaire (" + note + ")")
						.bouteille(b)
						.client(c)
						.date(ldf)
						.build();

				// Sauvegarde de l'Avis
				avisRepository.save(avis);

				// Incrémenter la date
				ldf = ldf.plusDays(10);
			}
			// Incrémenter la note
			note++;
		}
	}

	@Test
	void test_insertion_DB() {
		// Vider les collections avant insertion
		vider_Bouteilles_DB();
		vider_Avis_DB();

		// Insérer les bouteilles
		insertion_Bouteille_DB();
		final List<Bouteille> listeBouteilles = bouteilleRepository.findAll();
		assertThat(listeBouteilles).isNotNull();
		assertThat(listeBouteilles).isNotEmpty();
		assertThat(listeBouteilles.size()).isEqualTo(3);

		// Insérer les avis
		insertion_Avis_DB();
		final List<Avis> listeAvis = avisRepository.findAll();
		assertThat(listeAvis).isNotNull();
		assertThat(listeAvis).isNotEmpty();
		assertThat(listeAvis.size()).isEqualTo(9);
	}
}
