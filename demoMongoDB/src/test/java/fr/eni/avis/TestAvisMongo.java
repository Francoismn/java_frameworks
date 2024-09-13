package fr.eni.avis;

import fr.eni.avis.bo.Avis;
import fr.eni.avis.dal.AvisRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class TestAvisMongo {

    @Autowired
    private AvisRepository avisRepository;

    @Test
    public void saveReview(){

        Avis avis = Avis
                .builder()
                .content("lorem ipsum")
                .author("Jeanette")
                .createdAt(LocalDate.now())
                .build();

        Avis savedAvis = avisRepository.save(avis);
        Assertions.assertThat(savedAvis.getId()).isNotNull();
        System.out.println(savedAvis);
    }


}
