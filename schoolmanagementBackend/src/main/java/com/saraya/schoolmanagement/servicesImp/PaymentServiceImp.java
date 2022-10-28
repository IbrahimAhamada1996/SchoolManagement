package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Payment;
import com.saraya.schoolmanagement.repositories.PaymentRepository;
import com.saraya.schoolmanagement.services.PaymentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImp implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImp(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment findById(Long id) throws ResourceNotFoundException {
        Optional<Payment> payment = this.paymentRepository.findPaymentById(id);
        if(!payment.isPresent())
            throw new ResourceNotFoundException("Payment not available");
        return payment.get();
    }

    @Override
    public Payment savePayment(Payment payment) {
        payment.setCreatedAt(LocalDateTime.now());
        return this.paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        payment.setUpdatedAt(LocalDateTime.now());
        return this.paymentRepository.save(payment);
    }

    @Override
    public void deletePaymentById(Long id) throws ResourceNotFoundException {
        if (!this.paymentRepository.existsPaymentById(id))
            throw new ResourceNotFoundException("Impossible to delete this Payment");
        else
            this.paymentRepository.deleteById(id);
    }

    @Override
    public List<Payment> findAllPayments() {
        return this.paymentRepository.findAll();
    }

    @Override
    public Page<Payment> findAllPayments(Pageable pageable) {
        return this.paymentRepository.findAll(pageable);
    }

    @Override
    public void deleteAllPayments() {
        this.paymentRepository.deleteAll();
    }

    @Override
    public boolean isPaymentExist(Payment payment) {
        return false;
    }
}
