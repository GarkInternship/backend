package com.gark.project.Rpository;

import com.gark.project.Entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
