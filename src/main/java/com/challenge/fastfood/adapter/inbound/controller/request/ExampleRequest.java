package com.challenge.fastfood.adapter.inbound.controller.request;

import com.challenge.fastfood.adapter.outbound.repository.ExampleEntity;
import com.challenge.fastfood.domain.actor.Example;

public record ExampleRequest(String name, String description) {


    public static Example toDomain(ExampleRequest exampleRequest) {
        return new Example(exampleRequest.name(), exampleRequest.description());
    }

}
