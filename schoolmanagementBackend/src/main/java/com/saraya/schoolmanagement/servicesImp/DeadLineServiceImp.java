package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.DeadLine;
import com.saraya.schoolmanagement.repositories.DeadLineRepository;
import com.saraya.schoolmanagement.services.DeadLineService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DeadLineServiceImp implements DeadLineService {

    private final DeadLineRepository  deadLineRepository;

    public DeadLineServiceImp(DeadLineRepository deadLineRepository) {
        this.deadLineRepository = deadLineRepository;
    }


    @Override
    public DeadLine findById(Long slug) throws ResourceNotFoundException {
        Optional<DeadLine> deadLine = this.deadLineRepository.findDeadLineById(slug);
        if (!deadLine.isPresent())
            throw new ResourceNotFoundException("DeadLine not available");

        return deadLine.get();
    }

    @Override
    public DeadLine saveDeadLine(DeadLine deadLine) {
        deadLine.setCreatedAt(LocalDate.now());
        return this.deadLineRepository.save(deadLine);
    }

    @Override
    public DeadLine updateDeadLine(DeadLine deadLine) {
        deadLine.setUpdatedAt(LocalDate.now());
        return this.deadLineRepository.save(deadLine);
    }

    @Override
    public void deleteDeadLineById(Long slug) throws ResourceNotFoundException {
        if (!this.deadLineRepository.existsDeadLineById(slug))
            throw new ResourceNotFoundException("impossible to delete this deadline");
        else
            this.deadLineRepository.deleteById(slug);

    }

    @Override
    public List<DeadLine> findAllDeadLines() {
        return this.deadLineRepository.findAll();
    }

    @Override
    public Page<DeadLine> findAllDeadLines(Pageable pageable) {
        return this.deadLineRepository.findAll(pageable);
    }

    @Override
    public void deleteAllDeadLines() {
        this.deadLineRepository.deleteAll();
    }

    @Override
    public boolean isDeadLineExist(DeadLine deadLine) {
        return false;
    }
}
