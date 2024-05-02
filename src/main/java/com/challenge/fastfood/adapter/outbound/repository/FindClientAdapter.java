package com.challenge.fastfood.adapter.outbound.repository;

import com.challenge.fastfood.adapter.outbound.mapstruct.ClientMapper;
import com.challenge.fastfood.domain.actor.Client;
import com.challenge.fastfood.domain.ports.outbound.FindClientAdapterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindClientAdapter implements FindClientAdapterPort {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    @Override
    public Client findClient(String name) {

        ClientEntity clientEntity = clientRepository.findByName(name);
        return clientMapper.clientEntityToClient(clientEntity);
    }
}
