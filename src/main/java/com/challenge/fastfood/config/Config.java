package com.challenge.fastfood.config;

import com.challenge.fastfood.domain.ports.out.FindClientAdapterPort;
import com.challenge.fastfood.domain.ports.out.FindLunchItemsAdapterPort;
import com.challenge.fastfood.domain.ports.out.SaveClientAdapterPort;
import com.challenge.fastfood.domain.usecase.CreateClientUseCase;
import com.challenge.fastfood.domain.usecase.FindClientUseCase;
import com.challenge.fastfood.domain.usecase.FindLunchItemsUseCase;
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
    public FindLunchItemsUseCase findLunchItemsUseCase(FindLunchItemsAdapterPort findLunchItemsAdapterPort) {
        return new FindLunchItemsUseCase(findLunchItemsAdapterPort);
    }


}
