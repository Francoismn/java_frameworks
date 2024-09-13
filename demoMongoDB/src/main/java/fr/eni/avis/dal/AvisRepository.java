package fr.eni.avis.dal;

import fr.eni.avis.bo.Avis;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvisRepository extends MongoRepository<Avis, String> {
}
