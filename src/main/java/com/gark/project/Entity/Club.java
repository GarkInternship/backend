package com.gark.project.Entity;


import java.util.*;

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
@Document(collection = "clubs")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String nom,president,Location,type ;// type ??

    private Date foundationYear ;

//    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Contract> contracts ;

    @DBRef
    @JsonManagedReference(value = "club-contracts")
    private List<Contract> contracts = new ArrayList<>();

    @DBRef
//    @JsonManagedReference(value = "groups")
    private List<Group> groups = new ArrayList<>();





    public void setNom(String nom) {
        this.nom = nom;
    }


    public void setPresident(String president) {
        this.president = president;
    }


    public void setType(String type) {
        this.type = type;
    }


    public void setFoundationYear(Date foundationYear) {
        this.foundationYear = foundationYear;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

}
