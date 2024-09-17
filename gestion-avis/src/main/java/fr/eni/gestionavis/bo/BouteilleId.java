package fr.eni.gestionavis.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class BouteilleId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Field(name = "bottle_id")
    private int idBouteille;

    @Field(name = "region_id")
    private int idRegion;

    @Field(name = "color_id")
    private int idCouleur;
}
