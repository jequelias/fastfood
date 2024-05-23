package com.challenge.fastfood.domain.usecase.client;

import com.challenge.fastfood.config.exception.ClientException;
import com.challenge.fastfood.domain.entities.Client;
import com.challenge.fastfood.domain.ports.in.client.CreateClientUseCasePort;
import com.challenge.fastfood.domain.ports.out.client.FindClientAdapterPort;
import com.challenge.fastfood.domain.ports.out.client.SaveClientAdapterPort;

import java.util.List;

public class CreateClientUseCase  implements CreateClientUseCasePort {

    private final SaveClientAdapterPort saveClientAdapterPort;
    private final FindClientAdapterPort findClientAdapterPort;

    public CreateClientUseCase(SaveClientAdapterPort saveClientAdapterPort, FindClientAdapterPort findClientAdapterPort) {
        this.saveClientAdapterPort = saveClientAdapterPort;
        this.findClientAdapterPort = findClientAdapterPort;
    }

    public Client createClient(Client client) {

        if (client.getName() == null || client.getCpf() == null || client.getEmail() == null) {
            throw new ClientException("Invalid client, name, cpf and email are required");
        }

        if (client.getName().length() > 100) {
            throw new ClientException("Invalid name, max 100 characters");
        }

        if (client.getCpf().length() > 14 || client.getCpf().length() < 11) {
            throw new ClientException("Invalid CPF, max 14 characters and min 11 characters");
        }

        if (client.getEmail().length() > 100) {
            throw new ClientException("Invalid email, max 100 characters");
        }

        Client findClient = findClientAdapterPort
                .findClient(null, client.getCpf(), client.getEmail());


        if(findClient != null ){
            if (findClient.getCpf() != null || findClient.getEmail() != null) {
                throw new ClientException("Client already exists");
            }
        }

        return saveClientAdapterPort.saveClient(client);
    }


}

