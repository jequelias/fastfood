package com.challenge.fastfood.adapter.out.mapstruct;


import com.challenge.fastfood.adapter.in.controller.request.ClientRequest;
import com.challenge.fastfood.adapter.in.controller.response.ClientResponse;
import com.challenge.fastfood.adapter.out.repository.client.ClientEntity;
import com.challenge.fastfood.domain.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {

    Client clientRequestToClient(ClientRequest clientRequest);

    ClientResponse clientToClientResponse(Client client);
    List<ClientResponse> clientListToClientResponse(List<Client> client);

    ClientEntity clientToClientEntity(Client client);

    Client clientEntityToClient(ClientEntity clientEntity);

    List<Client> clientListEntityToClient(List<ClientEntity> clientEntity);

}
