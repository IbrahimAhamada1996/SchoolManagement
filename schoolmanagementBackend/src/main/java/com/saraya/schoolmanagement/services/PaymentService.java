package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaymentService {
    Payment findById(Long id) throws ResourceNotFoundException;

    Payment savePayment(Payment payment);

    Payment updatePayment(Payment payment);

    void deletePaymentById(Long id) throws ResourceNotFoundException;

    List<Payment> findAllPayments();
    Page<Payment> findAllPayments(Pageable pageable);

    void deleteAllPayments();

    boolean isPaymentExist(Payment payment);
}
