package com.ElectronicManagementSystemPayment.controller;

import com.ElectronicManagementSystemPayment.dto.PaymentDTO;
import com.ElectronicManagementSystemPayment.entity.Payment;
import com.ElectronicManagementSystemPayment.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
    private PaymentService paymentService;

	 @GetMapping("/all")
	    public ResponseEntity<List<Payment>> getAllPayments() {
	        List<Payment> payments = paymentService.getAllPayments();
	        return new ResponseEntity<>(payments, HttpStatus.OK);
	    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPaymentById(@PathVariable int id) {
        Optional<Payment> payment = paymentService.getPaymentById(id);
        if (payment.isPresent()) {
            return new ResponseEntity<>(payment.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Payment not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> createPayment(@RequestBody Payment payment) {
        String result = paymentService.createPayment(payment);
        if ("Payment created successfully".equals(result)) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePayment(@PathVariable int paymentId, @RequestBody Payment updatedPayment) {
        String result = paymentService.updatePayment(paymentId, updatedPayment);
        if (result.equals("Payment updated successfully")) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable int id) {
        String result = paymentService.deletePayment(id);
        if (result.equals("Payment deleted successfully")) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
}