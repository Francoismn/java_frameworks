package fr.eni.demoheritage;

import static org.assertj.core.api.Assertions.assertThat;

import fr.eni.demoheritage.entity.Medecin;
import fr.eni.demoheritage.entity.Patient;
import fr.eni.demoheritage.repository.MedecinRepository;
import fr.eni.demoheritage.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestHeritage {

    @Autowired
    private MedecinRepository medecinRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void saveMedecin(){

        System.out.println("*************************** Save Medecin ***************************");

        //ARRANGE
        Medecin medecin = Medecin
                .builder()
                .prenom("John")
                .prenom("Smith")
                .email("john.smith@gmail.com")
                .tel("0607080910")
                .adresse("Quimper")
                .dateDeNaissance(LocalDate.now())
                .specialite("Cardiologue")
                .numMedecin("FR001")
                .tarif(26f)
                .build();

        //ACT
        Medecin savedMedecin = medecinRepository.save(medecin);

        //ASSERT
        assertThat(savedMedecin.getId()).isGreaterThan(0);
        System.out.println(savedMedecin);
    }

    @Test
    public void savePatient(){

        System.out.println("*************************** Save Patient ***************************");

        //ARRANGE
        Patient patient = Patient
                .builder()
                .prenom("Bob")
                .prenom("Eponge")
                .email("bob.eponge@gmail.com")
                .tel("777777777")
                .adresse("Rennes")
                .dateDeNaissance(LocalDate.now())
                .nss("1423787587657654567")
                .build();

        //ACT
        Patient savedPatient = patientRepository.save(patient);

        //ASSERT
        assertThat(savedPatient.getId()).isGreaterThan(0);
        System.out.println(savedPatient);
    }

}
