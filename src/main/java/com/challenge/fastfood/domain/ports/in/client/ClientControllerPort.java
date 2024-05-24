package com.challenge.fastfood.domain.ports.in.client;

import com.challenge.fastfood.domain.entities.Client;

import java.util.List;

public interface ClientControllerPort {
    Client createClient(Client client);
    Client findClient(String name, String cpf, String email);
    List<Client> findAllClient(String name, String cpf, String email);
}
