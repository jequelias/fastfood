package com.challenge.fastfood.adapter.out.repository;

import com.challenge.fastfood.adapter.out.mapstruct.ClientMapper;
import com.challenge.fastfood.domain.entities.Client;
import com.challenge.fastfood.domain.ports.out.FindClientAdapterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindClientAdapter implements FindClientAdapterPort {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    @Override
    public Client findClient(String name, String cpf, String email) {

        ClientEntity clientEntity = clientRepository.findByNameOrCpfOrEmail(name, cpf, email);

        return clientMapper.clientEntityToClient(clientEntity);
    }

}
