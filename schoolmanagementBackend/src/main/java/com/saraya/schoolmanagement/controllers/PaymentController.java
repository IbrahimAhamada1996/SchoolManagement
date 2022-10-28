package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.PaymentDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.PaymentMapper;
import com.saraya.schoolmanagement.models.Payment;
import com.saraya.schoolmanagement.services.PaymentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    private final PaymentService paymentService;

    private final PaymentMapper paymentMapper;

    public PaymentController(PaymentService paymentService, PaymentMapper paymentMapper) {
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }

    @PostMapping
    public ResponseEntity<?>
    createPayment(@RequestBody PaymentDto paymentDto){

        Payment payment =  paymentService.savePayment(paymentMapper.dtoToModel(paymentDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentMapper.modelToDto(payment));
    }
    
    @GetMapping
    public ResponseEntity<List<PaymentDto>> findAll(){
      List<Payment> payments =  paymentService.findAllPayments();
      if (payments.isEmpty()){
          return new ResponseEntity<List<PaymentDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<PaymentDto>>( paymentMapper.modelsToDtos(payments), HttpStatus.OK);
    }

   /* @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Payment> payments = new ArrayList<Payment>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Payment> paymentPage = paymentService.findAllPayments(pageable);
        payments = paymentPage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("payments",paymentMapper.modelsToDtos(payments));
        response.put("currentPage",paymentPage.getNumber());
        response.put("totalItems",paymentPage.getTotalElements());
        response.put("totalPages",paymentPage.getTotalPages());
        if (payments.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }
*/
    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> findPaymentById(@PathVariable Long id) throws ResourceNotFoundException {
        PaymentDto paymentDto = paymentMapper.modelToDto(paymentService.findById(id));
        if (paymentDto == null || id ==null) {
            return new ResponseEntity<PaymentDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<PaymentDto>(paymentDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<PaymentDto> updatePaymentById(@RequestBody PaymentDto paymentDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<PaymentDto>(HttpStatus.NO_CONTENT);
        }
        Payment payment =  this.paymentService.updatePayment(this.paymentMapper.dtoToModel(paymentDto));
        return new ResponseEntity<PaymentDto>(this.paymentMapper.modelToDto(payment), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePaymentById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        paymentService.deletePaymentById(id);
        return ResponseEntity.noContent().build();
    }
}
