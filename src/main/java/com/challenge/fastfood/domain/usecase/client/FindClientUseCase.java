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
    public Client findClient(String cpf) {

        if (cpf == null) {
            throw new ClientException("The CPF is required");
        }

        Client client = findClientAdapterPort.findClient(cpf);

        if (client == null || client.getCpf() == null || client.getEmail() == null) {
            throw new ClientException("Client not found");
        }
        return client;
    }
}
