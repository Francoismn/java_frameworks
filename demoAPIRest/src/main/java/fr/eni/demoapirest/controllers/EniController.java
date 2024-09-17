package fr.eni.demoapirest.controllers;

import fr.eni.demoapirest.entities.Crayon;
import fr.eni.demoapirest.services.EniService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Crayon> getCrayons() {
        return eniService.listeCrayons();
    }
}


