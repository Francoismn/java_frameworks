package fr.eni.demoapirest.entities;

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

//@Entity
//@Table(name = "crayons")
public class Crayon {
    private int id;
    private String couleur;
    private String type;


}
