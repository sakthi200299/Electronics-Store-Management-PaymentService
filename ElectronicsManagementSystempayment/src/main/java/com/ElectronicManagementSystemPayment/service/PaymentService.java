package com.ElectronicManagementSystemPayment.service;
import com.ElectronicManagementSystemPayment.dto.PaymentDTO;
import com.ElectronicManagementSystemPayment.entity.Payment;
import com.ElectronicManagementSystemPayment.repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        try {
            return paymentRepository.findAll()
        } catch (Exception e) {
            // Log the exception or handle it as needed
            e.printStackTrace(); // Example: Print stack trace for debugging
            throw new RuntimeException("Failed to fetch all payments: " + e.getMessage());
        }
    }

    public Optional<Payment> getPaymentById(int id) {
        try {
            return paymentRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty(); // Return an empty Optional in case of an error
        }
    }

    public String createPayment(Payment payment) {
        try {
       //     payment.setPaymentStatus(true);
            paymentRepository.save(payment);
            return "Payment created successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to create payment: " + e.getMessage();
        }
    }

    public String updatePayment(int paymentId, Payment updatedPayment) {
        try {
            Optional<Payment> existingPayment = paymentRepository.findById(paymentId);
            if (existingPayment.isPresent()) {
                Payment payment = existingPayment.get();
                
                // Update other fields as necessary
                paymentRepository.save(payment);
                return "Payment updated successfully";
            } else {
                return "Payment not found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to update payment: " + e.getMessage();
        }
    }

    public String deletePayment(int id) {
        try {
            paymentRepository.deleteById(id);
            return "Payment deleted successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to delete payment: " + e.getMessage();
        }
    }
}