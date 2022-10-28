package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.enums.RoleName;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Role;
import com.saraya.schoolmanagement.repositories.RoleRepository;
import com.saraya.schoolmanagement.services.RoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByRoleName(RoleName roleName) throws ResourceNotFoundException {
        Optional<Role> role = this.roleRepository.findRoleByRoleName(roleName);
        if (!role.isPresent())
            throw new ResourceNotFoundException("Role not available");
        return role.get();
    }

    @Override
    public Role saveRole(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public void deleteRoleByRoleName(RoleName roleName) throws ResourceNotFoundException {
        if (!this.roleRepository.existsRoleByRoleName(roleName))
            throw new ResourceNotFoundException("Impossible to delete this Role");
        else
            this.roleRepository.deleteByRoleName(roleName);
    }

    @Override
    public List<Role> findAllRoles() {
        return this.roleRepository.findAll();
    }

    @Override
    public Page<Role> findAllRoles(Pageable pageable) {
        return this.roleRepository.findAll(pageable);
    }

    @Override
    public void deleteAllRoles() {
        this.roleRepository.deleteAll();
    }

    @Override
    public boolean isRoleExist(Role role) {
        return false;
    }

}
