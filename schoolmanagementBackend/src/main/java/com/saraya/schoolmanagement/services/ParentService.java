package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Parent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ParentService {
    Parent findById(Long id) throws ResourceNotFoundException;

    Parent saveParent(Parent parent);

    Parent updateParent(Parent parent);

    void deleteParentById(Long id) throws ResourceNotFoundException;

    List<Parent> findAllParents();
    Page<Parent> findAllParents(Pageable pageable);

    void deleteAllParents();

    boolean isParentExist(Parent parent);
}
