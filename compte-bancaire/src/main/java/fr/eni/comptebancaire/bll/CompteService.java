package fr.eni.comptebancaire.bll;

import fr.eni.comptebancaire.bo.Compte;
import fr.eni.comptebancaire.bo.ComptePK;

import java.util.Optional;

public interface CompteService {
    Optional<Compte> getCompteById(ComptePK id);
    void ajouterCompte(Compte compte);
    Optional<Compte> recupererCompteParNum(String numCompte);
    void crediter(Compte compte, double montant);
    void debiter(Compte compte, double montant) throws Exception;
    void virement(Compte emetteur, Compte beneficiaire, double montant) throws Exception;
}
