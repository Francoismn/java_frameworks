package fr.eni.gestionavis.bo.vin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BouteilleId implements Serializable {

    @Field("bottle_id")
    private int idBouteille;

    @Field("region_id")
    private int idRegion;

    @Field("color_id")
    private int idCouleur;

}
