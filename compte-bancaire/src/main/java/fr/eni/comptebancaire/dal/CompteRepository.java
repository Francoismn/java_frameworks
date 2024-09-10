package fr.eni.comptebancaire.dal;

import fr.eni.comptebancaire.bo.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompteRepository extends JpaRepository<Compte, Long> {

    Optional<Compte> findByNumCompte(String numCompte);
}
