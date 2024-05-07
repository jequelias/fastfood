package com.challenge.fastfood.adapter.out.mapstruct;


import com.challenge.fastfood.adapter.in.controller.request.ClientRequest;
import com.challenge.fastfood.adapter.in.controller.response.ClientResponse;
import com.challenge.fastfood.adapter.out.repository.ClientEntity;
import com.challenge.fastfood.domain.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {

    Client clientRequestToClient(ClientRequest clientRequest);

    ClientResponse clientToClientResponse(Client client);

    ClientEntity clientToClientEntity(Client client);

    Client clientEntityToClient(ClientEntity clientEntity);

}
