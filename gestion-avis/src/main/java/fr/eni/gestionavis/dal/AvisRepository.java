package fr.eni.gestionavis.dal;

import fr.eni.gestionavis.bo.vin.Bouteille;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvisRepository extends MongoRepository<Bouteille, String> {
}
