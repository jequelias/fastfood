package com.challenge.fastfood.domain.usecase.client;

import com.challenge.fastfood.domain.entities.Client;
import com.challenge.fastfood.domain.ports.out.client.SaveClientAdapterPort;

public class CreateClientUseCase {

    private final SaveClientAdapterPort saveClientAdapterPort;

    public CreateClientUseCase(SaveClientAdapterPort saveClientAdapterPort) {
        this.saveClientAdapterPort = saveClientAdapterPort;
    }

    public Client createClient(Client client) {
        return saveClientAdapterPort.saveClient(client);
    }


}

