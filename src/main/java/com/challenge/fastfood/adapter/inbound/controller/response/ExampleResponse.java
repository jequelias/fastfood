package com.challenge.fastfood.adapter.inbound.controller.response;

import com.challenge.fastfood.domain.actor.Example;

public record ExampleResponse(String name, String description) {

    public static ExampleResponse fromDomain(Example example) {
        return new ExampleResponse(example.getName(), example.getDescription());
    }
}
