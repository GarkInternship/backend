package com.gark.project.Rpository;

import com.gark.project.Entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, Long> {
    Role findRoleByName(String name);
}