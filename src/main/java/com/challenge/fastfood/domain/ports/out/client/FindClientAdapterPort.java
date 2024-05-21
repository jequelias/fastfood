package com.challenge.fastfood.domain.ports.out.client;

import com.challenge.fastfood.domain.entities.Client;

public interface FindClientAdapterPort {
    Client findClient(String name, String cpf, String email);
}
