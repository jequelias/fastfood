package com.challenge.fastfood.adapter.in;

import com.challenge.fastfood.domain.entities.Payment;
import com.challenge.fastfood.domain.ports.in.payment.PaymentControllerPort;
import com.challenge.fastfood.domain.usecase.payment.PaymentUseCase;

public class PaymentControllerAdapter implements PaymentControllerPort {

    private final PaymentUseCase paymentUseCase;

    public PaymentControllerAdapter(PaymentUseCase paymentUseCase) {
        this.paymentUseCase = paymentUseCase;
    }

    @Override
    public Payment processPayment(Payment payment) {
        return paymentUseCase.processPayment(payment);
    }
}
