package com.gark.project.Controller;

import com.gark.project.Entity.Joueur;
import com.gark.project.Service.JoueurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class JoueurController {

    @Autowired
    private JoueurServiceImpl joueurService;

    @GetMapping("view")
    public List<Joueur> getAllPlayers() {
        return joueurService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Joueur getPlayerById(@PathVariable String id) {
        return joueurService.getPlayerById(id);
    }

    @PostMapping("/add")
    public Joueur createPlayer(@RequestBody Joueur player) {
        return joueurService.savePlayer(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable String id) {
        joueurService.deletePlayer(id);
    }
}

