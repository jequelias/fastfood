package com.challenge.fastfood.domain.ports.in;

import com.challenge.fastfood.domain.entities.Client;

public interface FindClientUseCasePort {

    Client findClient(String name, String cpf, String email);
}
