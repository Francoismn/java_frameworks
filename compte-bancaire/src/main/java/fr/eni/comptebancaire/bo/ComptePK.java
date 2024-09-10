package fr.eni.comptebancaire.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComptePK implements Serializable {
    private String numCompte;
    private String pseudo;
}
