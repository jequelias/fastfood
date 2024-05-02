package com.challenge.fastfood.domain.usecase;

import com.challenge.fastfood.domain.actor.Example;
import com.challenge.fastfood.domain.ports.inbound.CreateExampleUseCasePort;
import com.challenge.fastfood.domain.ports.outbound.FindExampleAdapterPort;
import com.challenge.fastfood.domain.ports.outbound.SaveExampleAdapterPort;

public class CreateExampleUseCase implements CreateExampleUseCasePort {

    private final SaveExampleAdapterPort saveExampleAdapterPort;

    public CreateExampleUseCase(SaveExampleAdapterPort saveExampleAdapterPort) {
        this.saveExampleAdapterPort = saveExampleAdapterPort;

    }

    @Override
    public Example createExample(Example example) {
        return saveExampleAdapterPort.saveExample(example);
    }


}

