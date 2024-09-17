package fr.eni.gestionavis.bo;

import fr.eni.gestionavis.dal.AvisRepository;
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

    @Test
    public void saveReview(){
        Avis avis = Avis
                .builder()
                .note(2)
                .commentaire("C'est nul")
                .date(LocalDateTime.now()) // LocalDateTime pour correspondre à la classe Avis
                .build();

        Avis savedAvis = avisRepository.save(avis);
        Assertions.assertThat(savedAvis.getId()).isNotNull();
        System.out.println(savedAvis);
    }


    @Test
    public void recoverReviews(){
        List<Avis> avis = new ArrayList<>();
        avis.add(Avis
                .builder()
                .note(2)
                .commentaire("C'est nul")
                .date(LocalDateTime.now())
                .build());

        avis.add(Avis
                .builder()
                .note(5)
                .commentaire("C'est moyen")
                .date(LocalDateTime.now())
                .build());

        Assertions.assertThat(avis).isNotNull();
        System.out.println(avis);
    }
}
