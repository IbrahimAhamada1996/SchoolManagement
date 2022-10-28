package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.enums.RoleName;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {
    Role findByRoleName(RoleName roleName) throws ResourceNotFoundException;

    Role saveRole(Role role);

    Role updateRole(Role role);

    List<Role> findAllRoles();
    Page<Role> findAllRoles(Pageable pageable);

    void deleteAllRoles();

    boolean isRoleExist(Role role);

    void deleteRoleByRoleName(RoleName roleName) throws ResourceNotFoundException;
}
