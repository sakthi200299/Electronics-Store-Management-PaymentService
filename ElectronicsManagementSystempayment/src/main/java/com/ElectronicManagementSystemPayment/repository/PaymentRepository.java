package com.ElectronicManagementSystemPayment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ElectronicManagementSystemPayment.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}