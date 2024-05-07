package com.challenge.fastfood.domain.usecase;

import com.challenge.fastfood.domain.entities.Client;
import com.challenge.fastfood.domain.ports.in.CreateClientUseCasePort;
import com.challenge.fastfood.domain.ports.out.SaveClientAdapterPort;

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

