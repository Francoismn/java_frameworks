package fr.eni.demoapirest.dal;

import fr.eni.demoapirest.entities.Bonhomme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BonhommeRepository extends JpaRepository<Bonhomme, Integer> {
}
