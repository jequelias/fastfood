package com.challenge.fastfood.domain.ports.in.client;

import com.challenge.fastfood.domain.entities.Client;

public interface CreateClientUseCasePort {

    Client createClient(Client client);
}
