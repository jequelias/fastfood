package com.challenge.fastfood.domain.usecase.client;

import com.challenge.fastfood.config.exception.ClientException;
import com.challenge.fastfood.domain.entities.Client;
import com.challenge.fastfood.domain.ports.in.client.FindClientUseCasePort;
import com.challenge.fastfood.domain.ports.out.client.FindClientAdapterPort;

public class FindClientUseCase implements FindClientUseCasePort {

    private final FindClientAdapterPort findClientAdapterPort;

    public FindClientUseCase(FindClientAdapterPort findClientAdapterPort) {
        this.findClientAdapterPort = findClientAdapterPort;
    }

    @Override
    public Client findClient(String name, String cpf, String email) {

        if (name == null && cpf == null && email == null) {
            throw new ClientException("Invalid client, name, cpf or email are required");
        }

        Client client = findClientAdapterPort.findClient(name, cpf, email);

        if (client == null || client.getCpf() == null || client.getEmail() == null) {
            throw new ClientException("Client not found");
        }
        return client;
    }
}
