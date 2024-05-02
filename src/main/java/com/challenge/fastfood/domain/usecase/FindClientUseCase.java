package com.challenge.fastfood.domain.usecase;

import com.challenge.fastfood.domain.actor.Client;
import com.challenge.fastfood.domain.ports.inbound.FindClientUseCasePort;
import com.challenge.fastfood.domain.ports.outbound.FindClientAdapterPort;

public class FindClientUseCase implements FindClientUseCasePort {

    private final FindClientAdapterPort findClientAdapterPort;

    public FindClientUseCase(FindClientAdapterPort findClientAdapterPort) {
        this.findClientAdapterPort = findClientAdapterPort;
    }

    @Override
    public Client findClient(String name) {
        return findClientAdapterPort.findClient(name);
    }
}
