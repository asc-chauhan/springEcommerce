package com.ecommerce.anshul.repositories;

import com.ecommerce.anshul.model.AppRole;
import com.ecommerce.anshul.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(AppRole appRole);
}
