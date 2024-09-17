package fr.eni.gestionavis.dal;

import fr.eni.gestionavis.bo.Bouteille;
import fr.eni.gestionavis.bo.BouteilleId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BouteilleRepository extends MongoRepository<Bouteille, BouteilleId> {


}
