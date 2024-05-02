package com.challenge.fastfood.domain.usecase;

import com.challenge.fastfood.domain.actor.Client;
import com.challenge.fastfood.domain.ports.inbound.CreateClientUseCasePort;
import com.challenge.fastfood.domain.ports.outbound.SaveClientAdapterPort;

public class CreateClientUseCase implements CreateClientUseCasePort {

    private final SaveClientAdapterPort saveClientAdapterPort;

    public CreateClientUseCase(SaveClientAdapterPort saveClientAdapterPort) {
        this.saveClientAdapterPort = saveClientAdapterPort;

    }

    @Override
    public Client createClient(Client client) {
        return saveClientAdapterPort.saveClient(client);
    }


}

