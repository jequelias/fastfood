package com.challenge.fastfood.domain.usecase.client;

import com.challenge.fastfood.domain.entities.Client;
import com.challenge.fastfood.domain.ports.in.client.CreateClientUseCasePort;
import com.challenge.fastfood.domain.ports.out.client.SaveClientAdapterPort;

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

