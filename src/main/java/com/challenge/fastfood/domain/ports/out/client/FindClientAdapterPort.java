package com.challenge.fastfood.domain.ports.out.client;

import com.challenge.fastfood.domain.entities.Client;

public interface FindClientAdapterPort {
    Client findClient(String cpf);
    Client findClientById(Long id);
}
