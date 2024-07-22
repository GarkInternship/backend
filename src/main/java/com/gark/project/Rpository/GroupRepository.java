package com.gark.project.Rpository;

import com.gark.project.Entity.Club;
import com.gark.project.Entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface GroupRepository extends MongoRepository<Group, String> {
    Group findByNom(String nom);
    // Group findByNom(String nom);

    //Optional<Group> findByNom(String nom);

//    @Query("SELECT g FROM Group g WHERE g.nom ==nom ")
//    public boolean findByNom(@Param("nom") String nom);
}
