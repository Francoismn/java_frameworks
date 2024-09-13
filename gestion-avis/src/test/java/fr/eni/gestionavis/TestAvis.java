package fr.eni.gestionavis;

import fr.eni.gestionavis.bo.Avis;
import fr.eni.gestionavis.dal.AvisRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
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
                .commentary("C'est nul")
                .date(LocalDate.now())
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
                .commentary("C'est nul")
                .date(LocalDate.now())
                .build());

        avis.add(Avis
                .builder()
                .note(5)
                .commentary("C'est moyen")
                .date(LocalDate.now())
                .build());



        Assertions.assertThat(avis).isNotNull();
        System.out.println(avis);
    }

}
