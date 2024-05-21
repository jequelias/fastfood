package com.challenge.fastfood.adapter.in;

import com.challenge.fastfood.domain.entities.Client;
import com.challenge.fastfood.domain.ports.in.client.ClientControllerPort;
import com.challenge.fastfood.domain.usecase.client.CreateClientUseCase;
import com.challenge.fastfood.domain.usecase.client.FindClientUseCase;

public class ClientControllerAdapter implements ClientControllerPort {

    private final CreateClientUseCase createClientUseCase;
    private final FindClientUseCase findClientUseCase;

    public ClientControllerAdapter(
            CreateClientUseCase createClientUseCase,
            FindClientUseCase findClientUseCase) {
        this.createClientUseCase = createClientUseCase;
        this.findClientUseCase = findClientUseCase;

    }

    @Override
    public Client createClient(Client client) {
        return createClientUseCase.createClient(client);
    }

    @Override
    public Client findClient(String name, String cpf, String email) {
        return findClientUseCase.findClient(name, cpf, email);
    }
}
