package com.challenge.fastfood.domain.ports.in.client;

import com.challenge.fastfood.domain.entities.Client;

public interface ClientControllerPort {
    Client createClient(Client client);
    Client findClient(String cpf);
}
