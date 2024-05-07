package com.challenge.fastfood.domain.ports.out;

import com.challenge.fastfood.domain.entities.Client;

public interface SaveClientAdapterPort {

    Client saveClient(Client name);
}
