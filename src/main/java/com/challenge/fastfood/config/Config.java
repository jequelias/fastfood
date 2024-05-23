package com.challenge.fastfood.config;

import com.challenge.fastfood.adapter.in.ClientControllerAdapter;
import com.challenge.fastfood.adapter.in.LunchControllerAdapter;
import com.challenge.fastfood.adapter.in.LunchItemsControllerAdapter;
import com.challenge.fastfood.adapter.in.PaymentControllerAdapter;
import com.challenge.fastfood.adapter.out.repository.lunchItem.FindLunchItemsAdapter;
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
    public ClientControllerAdapter createClientControllerAdapter(
            CreateClientUseCase clientUseCase,
            FindClientUseCase findClientUseCase) {
        return new ClientControllerAdapter(clientUseCase, findClientUseCase);
    }

    @Bean
    public LunchControllerAdapter createLunchControllerAdapter(
            CreateLunchUseCase createLunchUseCase,
            FindLunchUseCase findLunchUseCase) {
        return new LunchControllerAdapter(createLunchUseCase, findLunchUseCase);
    }

    @Bean
    public LunchItemsControllerAdapter createLunchItemsControllerAdapter(
            CreateLunchItemUseCase createLunchItemUseCase,
            EditLunchItemUseCase editLunchItemUseCase,
            FindLunchItemsUseCase findLunchItemsUseCase) {
        return new LunchItemsControllerAdapter(createLunchItemUseCase, editLunchItemUseCase, findLunchItemsUseCase);
    }

    @Bean
    public PaymentControllerAdapter createPaymentControllerAdapter(PaymentUseCase paymentUseCase) {
        return new PaymentControllerAdapter(paymentUseCase);
    }


    @Bean
    public CreateClientUseCase createClientUseCase(SaveClientAdapterPort saveClientAdapterPort, FindClientAdapterPort findClientAdapterPort) {
        return new CreateClientUseCase(saveClientAdapterPort, findClientAdapterPort);
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
    public EditLunchItemUseCase editLunchItemUseCase(EditLunchItemAdapterPort deleteLunchItemAdapterPort, FindLunchItemsAdapter findLunchItemsAdapter) {
        return new EditLunchItemUseCase(deleteLunchItemAdapterPort,findLunchItemsAdapter );
    }

    @Bean
    public PaymentUseCase paymentUseCase(PaymentAdapterPort paymentAdapterPort) {
        return new PaymentUseCase(paymentAdapterPort);
    }


}
