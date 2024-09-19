package fr.eni.gestionavis.dal;

import fr.eni.gestionavis.bo.Bouteille;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "bouteille", collectionResourceRel = "bouteille")
public interface BouteilleRepository extends MongoRepository<Bouteille, String> {


}
