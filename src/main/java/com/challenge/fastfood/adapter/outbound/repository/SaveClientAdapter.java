package com.challenge.fastfood.adapter.outbound.repository;

import com.challenge.fastfood.adapter.outbound.mapstruct.ClientMapper;
import com.challenge.fastfood.domain.actor.Client;
import com.challenge.fastfood.domain.ports.outbound.SaveClientAdapterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveClientAdapter implements SaveClientAdapterPort {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public Client saveClient(Client client) {

        ClientEntity clientEntity = clientMapper.clientToClientEntity(client);
        ClientEntity clientEntitySaved = clientRepository.save(clientEntity);

        return clientMapper.clientEntityToClient(clientEntitySaved);
    }
}
