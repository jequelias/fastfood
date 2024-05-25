package com.challenge.fastfood.domain.ports.out.payment;

import com.challenge.fastfood.domain.entities.Payment;

public interface PaymentAdapterPort {

    Payment processPayment(Payment payment);
    Payment findPaymentByLunchId(Long lunchId);

}
