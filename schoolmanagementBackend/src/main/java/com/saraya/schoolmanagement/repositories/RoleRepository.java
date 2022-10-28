package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.enums.RoleName;
import com.saraya.schoolmanagement.models.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByRoleName(RoleName roleName);
    List<Role> findAll();
    Page<Role> findAll(Pageable pageable);
    void deleteByRoleName(RoleName roleName);
    boolean existsRoleByRoleName(RoleName roleName);
}