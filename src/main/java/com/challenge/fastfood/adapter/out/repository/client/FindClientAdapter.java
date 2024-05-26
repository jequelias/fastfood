package com.challenge.fastfood.adapter.out.repository.client;

import com.challenge.fastfood.adapter.out.mapstruct.ClientMapper;
import com.challenge.fastfood.domain.entities.Client;
import com.challenge.fastfood.domain.ports.out.client.FindClientAdapterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindClientAdapter implements FindClientAdapterPort {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public Client findClient(String cpf) {
        ClientEntity clientEntity = clientRepository.findByCpf(cpf);
        return clientMapper.clientEntityToClient(clientEntity);
    }

    @Override
    public Client findClientById(Long id) {
        ClientEntity clientEntity = clientRepository.findById(id).orElse(null);
        return clientMapper.clientEntityToClient(clientEntity);
    }

}
