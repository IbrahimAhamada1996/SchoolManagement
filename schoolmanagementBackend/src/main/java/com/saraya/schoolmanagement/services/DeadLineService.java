package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.DeadLine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DeadLineService {
    DeadLine findById(Long id) throws ResourceNotFoundException;

    DeadLine saveDeadLine(DeadLine deadLine);

    DeadLine updateDeadLine(DeadLine deadLine);

    void deleteDeadLineById(Long id) throws  ResourceNotFoundException;

    List<DeadLine> findAllDeadLines();
    Page<DeadLine> findAllDeadLines(Pageable pageable);

    void deleteAllDeadLines();

    boolean isDeadLineExist(DeadLine deadLine);
}
