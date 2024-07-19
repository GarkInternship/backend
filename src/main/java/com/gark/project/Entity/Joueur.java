package com.gark.project.Entity;


import java.time.LocalDate;
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
@Document(collection = "joueurs")
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String fullname,position;
    private int jerseyNumber;
    private float valeur ;



    private LocalDate bday ;

//    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Contract> contracts = new HashSet<>();

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "group_id")

    @DBRef
    @JsonManagedReference(value = "joueur-contracts")
    private List<Contract> contracts = new ArrayList<>();
    // it supposed to be 1 contract ?? and when it experied it will be expired ???


    @DBRef
    @JsonBackReference
    private Group group;






    public void setId(String id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public void setBday(LocalDate bday) {
        this.bday = bday;
    }
}
