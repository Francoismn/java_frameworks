package fr.eni.gestionavis;

import fr.eni.gestionavis.bo.vin.Bouteille;
import fr.eni.gestionavis.bo.vin.BouteilleId;
import fr.eni.gestionavis.dal.BouteilleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestBouteille {

    @Autowired
    private BouteilleRepository bouteilleRepository;

    private static BouteilleId bouteilleId;
    private static Bouteille bouteille;

    @BeforeAll
    public static void setup() {
        bouteilleId = BouteilleId.builder()
                .idBouteille(2298)
                .idRegion(5)
                .idCouleur(1)
                .build();

        bouteille = Bouteille.builder()
                .id(bouteilleId)
                .nom("Vin Blanc ENI")
                .build();

        System.out.println("Setup done: BouteilleId et Bouteille initialisés");
    }

    @Test
    public void saveBouteille() {
        Bouteille savedBouteille = bouteilleRepository.save(bouteille);
        Assertions.assertThat(savedBouteille).isNotNull();
        Assertions.assertThat(savedBouteille.getId()).isNotNull();
        Assertions.assertThat(savedBouteille.getId().getIdBouteille()).isNotNull();
        Assertions.assertThat(savedBouteille.getId().getIdCouleur()).isNotNull();
        Assertions.assertThat(savedBouteille.getId().getIdRegion()).isNotNull();
        System.out.println(savedBouteille);
    }

    @Test
    public void findBouteilleById() {
        Optional<Bouteille> bouteilleFound = bouteilleRepository.findById(bouteilleId);
        Assertions.assertThat(bouteilleFound).isPresent();
        System.out.println(bouteilleFound.get());
    }
}
