package com.challenge.fastfood.adapter.in.controller;

import com.challenge.fastfood.adapter.in.controller.request.PaymentRequest;
import com.challenge.fastfood.adapter.out.mapstruct.PaymentMapper;
import com.challenge.fastfood.domain.entities.Payment;
import com.challenge.fastfood.domain.ports.out.payment.PaymentAdapterPort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@Tag(name = "payment", description = "Payment Controller")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentAdapterPort paymentAdapterPort;
    private final PaymentMapper paymentMapper;

    @PostMapping("/process")
    public ResponseEntity<String> processPayment(@RequestBody PaymentRequest payment) {
        Payment processed = paymentAdapterPort.processPayment(paymentMapper.toPayment(payment));
        return ResponseEntity.ok(processed.getStatus());
    }
}