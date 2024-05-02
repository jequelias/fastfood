package com.challenge.fastfood.adapter.outbound.repository;

import com.challenge.fastfood.domain.actor.Example;
import com.challenge.fastfood.domain.ports.outbound.FindExampleAdapterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindExampleAdapter implements FindExampleAdapterPort {

    private final ExampleRepository exampleRepository;
    @Override
    public Example findExample(String name) {

       return exampleRepository.findByName(name).toDomain();
    }
}
