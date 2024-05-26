package com.challenge.fastfood.domain.ports.in.client;

import com.challenge.fastfood.domain.entities.Client;

public interface FindClientUseCasePort {

    Client findClient(String cpf);
}
