package com.challenge.fastfood.adapter.in.controller;

import com.challenge.fastfood.domain.ports.in.client.ClientControllerPort;
import com.challenge.fastfood.adapter.in.controller.request.ClientRequest;
import com.challenge.fastfood.adapter.in.controller.response.ClientResponse;
import com.challenge.fastfood.adapter.out.mapstruct.ClientMapper;
import com.challenge.fastfood.domain.entities.Client;
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

    private final ClientControllerPort clientControllerPort;
    private final ClientMapper clientMapper;


    @PostMapping
    @Operation(summary = "Create client", description = "Create a client")
    public ResponseEntity<ClientResponse> createClient(@RequestBody ClientRequest clientRequest) {
        Client client = clientControllerPort.createClient(clientMapper.clientRequestToClient(clientRequest));
        return ResponseEntity.ok(clientMapper.clientToClientResponse(client));
    }

    @GetMapping
    @Operation(summary = "Get client", description = "Get client")
    public ResponseEntity<ClientResponse> getClient(@RequestParam(required = false) String name,
                                                    @RequestParam(required = false) String cpf,
                                                    @RequestParam(required = false) String email) {
        Client client = clientControllerPort.findClient(
                name,
                cpf,
                email );
        return ResponseEntity.ok(clientMapper.clientToClientResponse(client));
    }

}
