package com.challenge.fastfood.config;

import com.challenge.fastfood.domain.ports.outbound.FindExampleAdapterPort;
import com.challenge.fastfood.domain.ports.outbound.SaveExampleAdapterPort;
import com.challenge.fastfood.domain.usecase.CreateExampleUseCase;
import com.challenge.fastfood.domain.usecase.FindExampleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CreateExampleUseCase createExampleUseCase(SaveExampleAdapterPort saveExampleAdapterPort ) {
        return new CreateExampleUseCase(saveExampleAdapterPort);
    }

    @Bean
    public FindExampleUseCase findExampleUseCase( FindExampleAdapterPort findExampleAdapterPort) {
        return new FindExampleUseCase(findExampleAdapterPort);
    }


}
