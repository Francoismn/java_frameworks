package fr.eni.demoheritage.repository;

import fr.eni.demoheritage.entity.Medecin;
import fr.eni.demoheritage.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Integer> {
}
