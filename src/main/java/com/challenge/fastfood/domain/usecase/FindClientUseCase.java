package com.challenge.fastfood.domain.usecase;

import com.challenge.fastfood.domain.entities.Client;
import com.challenge.fastfood.domain.ports.in.FindClientUseCasePort;
import com.challenge.fastfood.domain.ports.out.FindClientAdapterPort;

public class FindClientUseCase implements FindClientUseCasePort {

    private final FindClientAdapterPort findClientAdapterPort;

    public FindClientUseCase(FindClientAdapterPort findClientAdapterPort) {
        this.findClientAdapterPort = findClientAdapterPort;
    }

    @Override
    public Client findClient(String name, String cpf, String email) {
        return findClientAdapterPort.findClient(name, cpf, email);
    }
}
