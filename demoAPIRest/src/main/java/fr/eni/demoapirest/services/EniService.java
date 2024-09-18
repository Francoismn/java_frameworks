package fr.eni.demoapirest.services;

import fr.eni.demoapirest.entities.Crayon;


import java.util.Arrays;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EniService {

    private List<Crayon> crayonsBouchonnes = Arrays.asList(
            Crayon.builder().id(1).couleur("Rouge").type("Feutre").build(),
            Crayon.builder().id(2).couleur("Vert").type("Stylo").build(),
            Crayon.builder().id(3).couleur("Bleu").type("Stabilo").build()
    );

    public List<Crayon> listerCrayons() {
        return crayonsBouchonnes;
    };
}
