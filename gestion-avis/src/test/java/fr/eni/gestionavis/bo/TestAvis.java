package fr.eni.gestionavis.bo;

import fr.eni.gestionavis.dal.AvisRepository;
import fr.eni.gestionavis.dal.BouteilleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestAvis {

    @Autowired
    private AvisRepository avisRepository;

    @Autowired
    private BouteilleRepository bouteilleRepository;

    @Test
    public void saveReview(){
        // Créer un client
        Client client = Client.builder()
                .pseudo("bobeponge@email.fr")
                .quantiteCommandee(11)
                .build();

        // Créer une bouteille
        Bouteille bouteille = Bouteille.builder()
                .id(new BouteilleId(2298, 5, 1))
                .nom("Bordeaux Supérieur")
                .build();

        // Sauvegarder la bouteille dans le repository
        bouteilleRepository.save(bouteille);

        // Créer un avis avec le client et la bouteille
        Avis avis = Avis
                .builder()
                .note(5)
                .commentaire("Doux. À déguster frais.")
                .date(LocalDateTime.now())
                .client(client)  // Association avec le client
                .bouteille(bouteille)  // Association avec la bouteille
                .build();

        // Sauvegarder l'avis dans le repository
        Avis savedAvis = avisRepository.save(avis);

        // Vérifier que l'avis a bien été sauvegardé avec ses associations
        Assertions.assertThat(savedAvis.getId()).isNotNull();
        Assertions.assertThat(savedAvis.getClient()).isNotNull();
        Assertions.assertThat(savedAvis.getBouteille()).isNotNull();

        // Afficher l'avis pour vérifier son contenu
        System.out.println(savedAvis);
    }

    @Test
    public void recoverReviews(){
        List<Avis> avisList = avisRepository.findAll(); // Récupérer tous les avis depuis le repository

        // Vérifier que la liste des avis n'est pas vide
        Assertions.assertThat(avisList).isNotNull();
        Assertions.assertThat(avisList).isNotEmpty();

        // Afficher la liste des avis
        avisList.forEach(System.out::println);
    }
}
