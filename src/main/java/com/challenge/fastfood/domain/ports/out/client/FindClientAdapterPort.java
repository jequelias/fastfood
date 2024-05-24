package com.challenge.fastfood.domain.ports.out.client;

import com.challenge.fastfood.domain.entities.Client;

import java.util.List;

public interface FindClientAdapterPort {
    List<Client> findClientList(String name, String cpf, String email);
    Client findClient(String name, String cpf, String email);
}
