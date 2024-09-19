package fr.eni.gestionavis.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "bottles")
public class Bouteille {

    @Id
    @Field(name = "bottle_id")
    private String idBouteille;

    @Field(name = "name")
    private String nom;

    @Field(name = "region_id")
    private int idRegion;

    @Field(name = "color_id")
    private int idCouleur;

    private Bouteille bouteille;


}
