package com.challenge.fastfood.domain.ports.in;

import com.challenge.fastfood.domain.entities.Client;

public interface CreateClientUseCasePort {

    Client createClient(Client example);

}
