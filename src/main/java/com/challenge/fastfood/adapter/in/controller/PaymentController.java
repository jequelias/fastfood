package com.challenge.fastfood.adapter.in.controller;

import com.challenge.fastfood.adapter.out.mapstruct.PaymentMapper;
import com.challenge.fastfood.domain.entities.Payment;
import com.challenge.fastfood.domain.ports.out.payment.PaymentAdapterPort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Tag(name = "payment", description = "Payment Controller")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentAdapterPort paymentAdapterPort;
    private final PaymentMapper paymentMapper;

    @PostMapping("/process/{lunchId}")
    public ResponseEntity<String> processPayment(@PathVariable Long lunchId) {
        Payment payment = paymentAdapterPort.findPaymentByLunchId(lunchId);
        Payment processed = paymentAdapterPort.processPayment(payment);
        return ResponseEntity.ok(processed.getStatus());
    }
}