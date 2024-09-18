package fr.eni.demoapirest.controllers;

import fr.eni.demoapirest.entities.Bonhomme;
import fr.eni.demoapirest.services.BonhommeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bonhommes")
public class BonhommeController {

    private BonhommeService bonhommeService;

    public BonhommeController(BonhommeService bonhommeService) {
        this.bonhommeService = bonhommeService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Bonhomme> bonhommeList = bonhommeService.getAll();
        if (bonhommeList == null || bonhommeList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bonhommeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Bonhomme bonhomme = bonhommeService.getById(id);
        if (bonhomme == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bonhomme);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Bonhomme bonhomme) {
        try {
            bonhommeService.save(bonhomme);
            return ResponseEntity.status(HttpStatus.CREATED).body(bonhomme);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(bonhomme);
        }
    }

}

