package fr.eni.demoapirest.controllers;

import fr.eni.demoapirest.entities.Crayon;
import fr.eni.demoapirest.services.EniService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eniecole")
public class EniController {

    private EniService eniService;

    public EniController(EniService eniService) {
        this.eniService = eniService;
    }

    @GetMapping
    public String welcome() {
        return "Welcome to the Eni School";
    }

    @GetMapping(path = "/crayons")
    public ResponseEntity<?> getCrayons() {
        List<Crayon> resultats = eniService.listerCrayons();
        if (resultats == null || resultats.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultats);
    }

    @GetMapping(path = "/crayons/{id}")
    public ResponseEntity<?> getCrayonsById(@PathVariable int id) {
        try {
            Crayon crayon = eniService.getCrayonsById(id);
            return ResponseEntity.ok(crayon);
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

}


