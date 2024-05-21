package com.challenge.fastfood.config;

import com.challenge.fastfood.domain.ports.out.client.FindClientAdapterPort;
import com.challenge.fastfood.domain.ports.out.client.SaveClientAdapterPort;
import com.challenge.fastfood.domain.ports.out.lunch.FindLunchAdapterPort;
import com.challenge.fastfood.domain.ports.out.lunch.SaveLunchAdapterPort;
import com.challenge.fastfood.domain.ports.out.lunchItem.EditLunchItemAdapterPort;
import com.challenge.fastfood.domain.ports.out.lunchItem.FindLunchItemsAdapterPort;
import com.challenge.fastfood.domain.ports.out.lunchItem.SaveLunchItemAdapterPort;
import com.challenge.fastfood.domain.ports.out.payment.PaymentAdapterPort;
import com.challenge.fastfood.domain.usecase.client.CreateClientUseCase;
import com.challenge.fastfood.domain.usecase.client.FindClientUseCase;
import com.challenge.fastfood.domain.usecase.lunch.CreateLunchUseCase;
import com.challenge.fastfood.domain.usecase.lunch.FindLunchUseCase;
import com.challenge.fastfood.domain.usecase.lunchItem.CreateLunchItemUseCase;
import com.challenge.fastfood.domain.usecase.lunchItem.EditLunchItemUseCase;
import com.challenge.fastfood.domain.usecase.lunchItem.FindLunchItemsUseCase;
import com.challenge.fastfood.domain.usecase.payment.PaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CreateClientUseCase createClientUseCase(SaveClientAdapterPort saveClientAdapterPort) {
        return new CreateClientUseCase(saveClientAdapterPort);
    }

    @Bean
    public FindClientUseCase findClientUseCase(FindClientAdapterPort findClientAdapterPort) {
        return new FindClientUseCase(findClientAdapterPort);
    }

    @Bean
    public CreateLunchItemUseCase createLunchItemUseCase(SaveLunchItemAdapterPort saveLunchItemAdapterPort) {
        return new CreateLunchItemUseCase(saveLunchItemAdapterPort);
    }

    @Bean
    public FindLunchItemsUseCase findLunchItemsUseCase(FindLunchItemsAdapterPort findLunchItemsAdapterPort) {
        return new FindLunchItemsUseCase(findLunchItemsAdapterPort);
    }

    @Bean
    public CreateLunchUseCase createLunchUseCase(SaveLunchAdapterPort saveLunchAdapterPort) {
        return new CreateLunchUseCase(saveLunchAdapterPort);
    }


    @Bean
    public FindLunchUseCase findLunchUseCase(FindLunchAdapterPort findLunchAdapterPort) {
        return new FindLunchUseCase(findLunchAdapterPort);
    }

    @Bean
    public EditLunchItemUseCase deleteLunchItemUseCase(EditLunchItemAdapterPort deleteLunchItemAdapterPort) {
        return new EditLunchItemUseCase(deleteLunchItemAdapterPort);
    }

    @Bean
    public PaymentUseCase paymentUseCase(PaymentAdapterPort paymentAdapterPort) {
        return new PaymentUseCase(paymentAdapterPort);
    }


}
