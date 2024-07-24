package com.gark.project.Rpository;

import com.gark.project.Entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
