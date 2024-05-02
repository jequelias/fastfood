package com.challenge.fastfood.domain.usecase;

import com.challenge.fastfood.domain.actor.Example;
import com.challenge.fastfood.domain.ports.inbound.FindExampleUseCasePort;
import com.challenge.fastfood.domain.ports.outbound.FindExampleAdapterPort;

public class FindExampleUseCase implements FindExampleUseCasePort {

    private final FindExampleAdapterPort findExampleAdapterPort;

    public FindExampleUseCase(FindExampleAdapterPort findExampleAdapterPort) {
        this.findExampleAdapterPort = findExampleAdapterPort;
    }

    @Override
    public Example findExample(String name) {
        return findExampleAdapterPort.findExample(name);
    }
}
