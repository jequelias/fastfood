package com.challenge.fastfood.domain.ports.out.client;

import com.challenge.fastfood.domain.entities.Client;

public interface SaveClientAdapterPort {

    Client saveClient(Client name);
}
