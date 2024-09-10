package fr.eni.comptebancaire;

import fr.eni.comptebancaire.bll.CompteService;
import fr.eni.comptebancaire.bo.Compte;
import fr.eni.comptebancaire.bo.ComptePK;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestCompteService {

    @Autowired
    private CompteService compteService;

    @Test
    public void testGetCompteById() {
        Compte compteLucas = Compte.builder()
                .numCompte("FR87654321")
                .pseudo("Lucas")
                .build();

        compteService.ajouterCompte(compteLucas);

        ComptePK id = ComptePK.builder()
                .numCompte("FR87654321")
                .pseudo("Lucas")
                .build();

        Optional<Compte> compteBddOpt = compteService.getCompteById(id);
        Assertions.assertThat(compteBddOpt).isPresent();
        System.out.println(compteBddOpt.get());


    }




    @Test
    public void testSaveCompte() {

        Compte compteLucas = Compte.builder()
                .numCompte("FR87654321")
                .solde(0)
                .pseudo("Lucas")
                .build();

        Compte compteGaelle = Compte.builder()
                .numCompte("FR12345678")
                .solde(0)
                .pseudo("Gaelle")
                .build();

        Compte compteFrancois = Compte.builder()
                .numCompte("FR000001")
                .solde(0)
                .pseudo("Francois")
                .build();

        compteService.ajouterCompte(compteLucas);
        compteService.ajouterCompte(compteGaelle);
        compteService.ajouterCompte(compteFrancois);

        Assertions.assertThat(compteLucas).isNotNull();
        Assertions.assertThat(compteGaelle).isNotNull();
        Assertions.assertThat(compteFrancois).isNotNull();

    }

    @Test
    public void testCrediter() {
        Optional<Compte> lucasCompteOpt = compteService.recupererCompteParNum("FR12345678");

        double oldSolde = 0;
        if (lucasCompteOpt.isPresent()){
            oldSolde = lucasCompteOpt.get().getSolde();
        }
        Assertions.assertThat(lucasCompteOpt).isPresent();
        Compte lucasCompte = lucasCompteOpt.get();
        compteService.crediter(lucasCompte, 10000);
        Assertions.assertThat(lucasCompte.getSolde()).isEqualTo(oldSolde + 10000);
    }

    @Test
    public void testDebiter() throws Exception {
        Optional<Compte> lucasCompteOpt = compteService.recupererCompteParNum("FR87654321");

        double oldSolde = 0;
        if (lucasCompteOpt.isPresent()){
            oldSolde = lucasCompteOpt.get().getSolde();
        }
        Assertions.assertThat(lucasCompteOpt).isPresent();
        Compte lucasCompte = lucasCompteOpt.get();
        try{
            compteService.debiter(lucasCompte, 500);
            Assertions.assertThat(lucasCompte.getSolde()).isEqualTo(oldSolde - 500);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testVirement() {
        Optional<Compte> lucasCompteOpt = compteService.recupererCompteParNum("FR87654321");
        Optional<Compte> gaelleCompteOpt = compteService.recupererCompteParNum("FR12345678");

        Assertions.assertThat(lucasCompteOpt).isPresent();
        Assertions.assertThat(gaelleCompteOpt).isPresent();

        try {
            compteService.virement(lucasCompteOpt.get(),gaelleCompteOpt.get(), 1000);
            Assertions.assertThat(lucasCompteOpt.get().getSolde()).isEqualTo(2500);
            Assertions.assertThat(gaelleCompteOpt.get().getSolde()).isEqualTo(1000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
