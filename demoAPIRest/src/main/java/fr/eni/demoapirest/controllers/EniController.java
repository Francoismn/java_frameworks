package fr.eni.demoapirest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eniecole")
public class EniController {

    public String welcome() {
        return "Welcome to the Eni School";
    }
}
