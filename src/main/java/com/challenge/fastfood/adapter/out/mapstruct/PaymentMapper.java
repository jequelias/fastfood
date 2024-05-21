package com.challenge.fastfood.adapter.out.mapstruct;

import com.challenge.fastfood.adapter.in.controller.request.PaymentRequest;
import com.challenge.fastfood.domain.entities.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {

    Payment toPayment(PaymentRequest paymentRequest);

    PaymentRequest toPaymentRequest(Payment payment);
}
