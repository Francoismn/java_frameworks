package fr.eni.gestionavis.bo;

import fr.eni.gestionavis.dal.AvisRepository;
import fr.eni.gestionavis.dal.BouteilleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestRequetesAvis {

    @Autowired
    private AvisRepository avisRepository;

    @Autowired
    private BouteilleRepository bouteilleRepository;


    @Test
    public void findByNoteLessThan() {
        List<Avis> avisList = avisRepository.findByNoteLessThan(3);
        System.out.println("Le nombre d'Avis avec une note < 3 est de : " + avisList.size());
        Assertions.assertThat(avisList).hasSize(3);
        avisList.forEach(System.out::println);
    }

    @Test
    public void findByNoteGreaterThanEqual() {
        List<Avis> avisList = avisRepository.findByNoteGreaterThanEqual(3);
        System.out.println("Le nombre d'Avis avec une note >= 3 est de : " + avisList.size());
        Assertions.assertThat(avisList).hasSize(6);
        avisList.forEach(System.out::println);
    }

    @Test
    public void findByBouteille() {
        Bouteille bouteille = bouteilleRepository.findById(new BouteilleId(18298, 3, 1)).orElse(null);
        Assertions.assertThat(bouteille).isNotNull();
        List<Avis> avisList = avisRepository.findByBouteille(bouteille);
        System.out.println("Le nombre d'avis pour la bouteille " + bouteille.getNom() + " est de : " + avisList.size());
        Assertions.assertThat(avisList).hasSize(3);
        avisList.forEach(System.out::println);
    }






}
