package fr.eni.comptebancaire.bll;

import fr.eni.comptebancaire.bo.Compte;
import fr.eni.comptebancaire.bo.ComptePK;
import fr.eni.comptebancaire.dal.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CompteServiceImpl implements CompteService{

    @Autowired
    private CompteRepository compteRepository;

    @Override
    public Optional<Compte> getCompteById(ComptePK id) {
        return compteRepository.findById(id);
    }

    @Override
    public void ajouterCompte(Compte compte) {
        //Vérification avant
        compteRepository.save(compte);
    }

    @Override
    public Optional<Compte> recupererCompteParNum(String numCompte) {
        return compteRepository.findByNumCompte(numCompte);
    }

    @Override
    public void crediter(Compte compte, double montant) {
        //Vérification avant
        compte.setSolde(compte.getSolde() + montant);
        compteRepository.save(compte);
    }

    @Override
    public void debiter(Compte compte, double montant) throws Exception {
        //Vérification
        if(compte.getSolde() < montant) throw new Exception("Solde insuffisant");
        compte.setSolde(compte.getSolde() - montant);
        compteRepository.save(compte);

    }

    @Transactional
    @Override
    public void virement(Compte emetteur, Compte beneficiaire, double montant) throws Exception {
        debiter(emetteur, montant);
        crediter(beneficiaire, montant);

    }
}
