package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends CrudRepository<Payment,Long> {
    Optional<Payment> findPaymentById(Long id);
    List<Payment> findAll();
    Page<Payment> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsPaymentById(Long id);
}
