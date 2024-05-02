package com.challenge.fastfood.adapter.inbound.controller;

import com.challenge.fastfood.adapter.inbound.controller.request.ExampleRequest;
import com.challenge.fastfood.adapter.inbound.controller.response.ExampleResponse;
import com.challenge.fastfood.domain.actor.Example;
import com.challenge.fastfood.domain.ports.inbound.CreateExampleUseCasePort;
import com.challenge.fastfood.domain.ports.inbound.FindExampleUseCasePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/example")
@Tag(name = "Example", description = "Example Controller")
@RequiredArgsConstructor
public class ExampleController {

    private final CreateExampleUseCasePort createExampleUseCasePort;
    private final FindExampleUseCasePort findExampleUseCasePort;


    @PostMapping("/create")
    @Operation(summary = "Create example", description = "Create a example")
    public ResponseEntity<ExampleResponse> createExample(@RequestBody ExampleRequest exampleRequest) {
        Example example = createExampleUseCasePort.createExample(ExampleRequest.toDomain(exampleRequest));
        return ResponseEntity.ok(ExampleResponse.fromDomain(example));
    }

    @GetMapping("/{name}")
    @Operation(summary = "Get example by name", description = "Get example by name")
    public ResponseEntity<ExampleResponse> getExampleName(@PathVariable String name) {
        Example example = findExampleUseCasePort.findExample(name);
        return ResponseEntity.ok(ExampleResponse.fromDomain(example));
    }

}
