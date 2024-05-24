package com.challenge.fastfood.domain.ports.in.client;

import com.challenge.fastfood.domain.entities.Client;

import java.util.List;

public interface FindClientUseCasePort {

    Client findClient(String name, String cpf, String email);
    List<Client> findClients(String name, String cpf, String email);
}
