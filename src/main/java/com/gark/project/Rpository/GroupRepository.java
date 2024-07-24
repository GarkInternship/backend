package com.gark.project.Rpository;

import com.gark.project.Entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByNom(String nom);
    // Group findByNom(String nom);

    //Optional<Group> findByNom(String nom);

//    @Query("SELECT g FROM Group g WHERE g.nom ==nom ")
//    public boolean findByNom(@Param("nom") String nom);
}
