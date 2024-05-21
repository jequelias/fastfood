package com.challenge.fastfood.adapter.out.repository.client;

import com.challenge.fastfood.adapter.out.mapstruct.ClientMapper;
import com.challenge.fastfood.config.exception.ClientException;
import com.challenge.fastfood.domain.entities.Client;
import com.challenge.fastfood.domain.ports.out.client.SaveClientAdapterPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveClientAdapter implements SaveClientAdapterPort {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    @Transactional
    public Client saveClient(Client client) {

        clientRepository.findByCpf(client.getCpf())
                .ifPresent(clientEntity -> {
                    throw new ClientException("Client already exists.");
                });

        ClientEntity clientEntity = clientMapper.clientToClientEntity(client);
        ClientEntity clientEntitySaved = clientRepository.save(clientEntity);

        return clientMapper.clientEntityToClient(clientEntitySaved);
    }
}
