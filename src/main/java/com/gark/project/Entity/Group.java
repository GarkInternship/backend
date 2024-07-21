package com.gark.project.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String nom,type ;// type ??

    private Niveau niveau ;

    @DBRef
    @JsonBackReference(value = "club-groups")
    private Club club ;

    @DBRef
    @JsonManagedReference
    private List<Joueur> players = new ArrayList<>();

    public Group(String nom) {
        this.nom = nom;
    }

    public Group(String nom, Club club) {
        this.nom = nom;
        this.club = club;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public enum Niveau {
        Cadet ,
        Senior,
        Junior,
        Minim,
        Poussin ,
        Benjamin

//                10 ans ou moins : Poussin.
//                11 et 12 ans : Benjamin.
//                13 et 14 ans : Minime.
//                15 à 17 ans : Cadet.
//                18 à 20 ans : Junior.
//                de 21 à 39 ans : Sénior 1.
    }
}
