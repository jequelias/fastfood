package com.challenge.fastfood.config;

import com.challenge.fastfood.domain.ports.out.*;
import com.challenge.fastfood.domain.usecase.*;
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


}
