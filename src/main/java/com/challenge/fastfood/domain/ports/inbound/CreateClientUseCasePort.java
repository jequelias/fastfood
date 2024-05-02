package com.challenge.fastfood.domain.ports.inbound;

import com.challenge.fastfood.domain.actor.Client;

public interface CreateClientUseCasePort {

    Client createClient(Client example);

}
