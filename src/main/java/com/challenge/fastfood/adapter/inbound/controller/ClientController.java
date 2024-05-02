package com.challenge.fastfood.adapter.inbound.controller;

import com.challenge.fastfood.adapter.inbound.controller.request.ClientRequest;
import com.challenge.fastfood.adapter.inbound.controller.response.ClientResponse;
import com.challenge.fastfood.adapter.outbound.mapstruct.ClientMapper;
import com.challenge.fastfood.domain.actor.Client;
import com.challenge.fastfood.domain.ports.inbound.CreateClientUseCasePort;
import com.challenge.fastfood.domain.ports.inbound.FindClientUseCasePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@Tag(name = "Client", description = "Client Controller")
@RequiredArgsConstructor
public class ClientController {

    private final CreateClientUseCasePort createClientUseCasePort;
    private final FindClientUseCasePort findClientUseCasePort;
    private final ClientMapper clientMapper;


    @PostMapping("/create")
    @Operation(summary = "Create client", description = "Create a client")
    public ResponseEntity<ClientResponse> createClient(@RequestBody ClientRequest clientRequest) {
        Client client = createClientUseCasePort.createClient(clientMapper.clientRequestToClient(clientRequest));
        return ResponseEntity.ok(clientMapper.clientToClientResponse(client));
    }

    @GetMapping("/{name}")
    @Operation(summary = "Get client by name", description = "Get client by name")
    public ResponseEntity<ClientResponse> getClientName(@PathVariable String name) {
        Client client = findClientUseCasePort.findClient(name);
        return ResponseEntity.ok(clientMapper.clientToClientResponse(client));
    }

}
