package com.challenge.fastfood.domain.ports.in.payment;

import com.challenge.fastfood.domain.entities.Payment;

public interface PaymentControllerPort {
    Payment processPayment(Payment payment);
}
