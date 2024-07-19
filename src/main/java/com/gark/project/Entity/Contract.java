package com.gark.project.Entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Document(collection = "contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String titre,details ;
    private Etat etat ;

    @DBRef
    @JsonBackReference(value = "club-contracts")
    private Club club;

    @DBRef
    @JsonBackReference(value = "joueur-contracts")
    private Joueur joueur;

    public enum Etat {
        Expired ,
        OnGoing ,
        OnHold
    }
}
