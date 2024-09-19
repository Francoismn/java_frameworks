package fr.eni.gestionavis.dal;

import fr.eni.gestionavis.bo.Avis;
import fr.eni.gestionavis.bo.Bouteille;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@RepositoryRestResource(path = "avis", collectionResourceRel = "avis")
public interface AvisRepository extends MongoRepository<Avis, String> {

    //Restitue tous les avis dont la note est inférieure au paramère
    List<Avis> findByNoteLessThan(@Param("note") int note);

    //Restitue tous les avis dont la note est supérieure ou égale au paramère
    List<Avis> findByNoteGreaterThanEqual(@Param("note") int note);

    //Tous les avis d'un stagiaire
    List<Avis> findByBouteilleId(String bouteilleId);

    // Requête pour récupérer les avis associés à un client spécifique
    List<Avis> findByClientPseudo(String pseudo);

    // Requête pour récupérer les avis dont la quantité commandée dépasse celle en paramètre
    List<Avis> findByClientQuantiteCommandeeGreaterThan(int quantite);

    // Requête pour récupérer les avis dont la date est comprise entre deux dates
    List<Avis> findByDateBetween(
            @Param("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @Param("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate
    );



}
