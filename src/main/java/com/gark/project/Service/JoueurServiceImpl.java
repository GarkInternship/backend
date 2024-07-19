package com.gark.project.Service;

import com.gark.project.Entity.Joueur;
import com.gark.project.Rpository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoueurServiceImpl implements JoueurService{

    @Autowired
    private JoueurRepository JoueurRepository;

    public List<Joueur> getAllPlayers() {
        return (List<Joueur>) JoueurRepository.findAll();
    }

    public Joueur getPlayerById(String id) {
        return JoueurRepository.findById(id).orElse(null);
    }

    public Joueur savePlayer(Joueur player) {
        return JoueurRepository.save(player);
    }

    public void deletePlayer(String id) {
        JoueurRepository.deleteById(id);
    }
}