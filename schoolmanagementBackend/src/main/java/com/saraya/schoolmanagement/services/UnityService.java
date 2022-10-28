package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Unity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UnityService {
    Unity findById(Long id) throws ResourceNotFoundException;

    Unity saveUnity(Unity unity);

    Unity updateUnity(Unity unity);

    void deleteUnityById(Long id) throws ResourceNotFoundException;

    List<Unity> findAllUnitys();
    Page<Unity> findAllUnitys(Pageable pageable);

    void deleteAllUnitys();

    boolean isUnityExist(Unity unity);
}
