package fr.eni.comptebancaire.dal;

import fr.eni.comptebancaire.bo.Compte;
import fr.eni.comptebancaire.bo.ComptePK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompteRepository extends JpaRepository<Compte, ComptePK> {
    Optional<Compte> findByNumCompte(String numCompte);
}
