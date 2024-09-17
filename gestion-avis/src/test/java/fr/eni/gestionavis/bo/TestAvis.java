package fr.eni.gestionavis.bo;

import fr.eni.gestionavis.dal.AvisRepository;
import fr.eni.gestionavis.dal.BouteilleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class TestAvis {

    @Autowired
    private AvisRepository avisRepository;

    @Autowired
    private BouteilleRepository bouteilleRepository;

    @Test
    public void saveReview(){
        Client client = Client.builder()
                .pseudo("bobeponge@email.fr")
                .quantiteCommandee(11)
                .build();

        Bouteille bouteille = Bouteille.builder()
                .id(new BouteilleId(2298, 5, 1))
                .nom("Bordeaux Supérieur")
                .build();

        bouteilleRepository.save(bouteille);

        Avis avis = Avis
                .builder()
                .note(5)
                .commentaire("Doux. À déguster frais.")
                .date(LocalDateTime.now())
                .client(client)  // Association avec le client
                .bouteille(bouteille)  // Association avec la bouteille
                .build();

        Avis savedAvis = avisRepository.save(avis);

        Assertions.assertThat(savedAvis.getId()).isNotNull();
        Assertions.assertThat(savedAvis.getClient()).isNotNull();
        Assertions.assertThat(savedAvis.getBouteille()).isNotNull();

        System.out.println(savedAvis);
    }

    @Test
    public void recoverReviews(){
        List<Avis> avisList = avisRepository.findAll();

        Assertions.assertThat(avisList).isNotNull();
        Assertions.assertThat(avisList).isNotEmpty();

        avisList.forEach(System.out::println);
    }


}
