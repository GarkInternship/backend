package com.gark.project.Rpository;

import com.gark.project.Entity.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {
}
