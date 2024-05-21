package com.challenge.fastfood.domain.usecase.payment;

import com.challenge.fastfood.domain.entities.Payment;
import com.challenge.fastfood.domain.ports.in.payment.PaymentUseCasePort;
import com.challenge.fastfood.domain.ports.out.payment.PaymentAdapterPort;

public class PaymentUseCase implements PaymentUseCasePort {

    private final PaymentAdapterPort paymentAdapterPort;

    public PaymentUseCase(PaymentAdapterPort paymentAdapterPort) {
        this.paymentAdapterPort = paymentAdapterPort;
    }

    @Override
    public Payment processPayment(Payment payment) {
        return paymentAdapterPort.processPayment(payment);
    }
}
