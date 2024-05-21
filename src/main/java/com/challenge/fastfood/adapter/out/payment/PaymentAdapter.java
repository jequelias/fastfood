package com.challenge.fastfood.adapter.out.payment;

import com.challenge.fastfood.domain.entities.Payment;
import com.challenge.fastfood.domain.ports.out.payment.PaymentAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class PaymentAdapter implements PaymentAdapterPort {

    @Override
    public Payment processPayment(Payment payment) {
        payment.setPaymentStatus("Payment processed successfully");
        return payment;
    }
}
