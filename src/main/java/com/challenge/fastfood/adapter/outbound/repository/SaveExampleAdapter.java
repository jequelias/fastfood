package com.challenge.fastfood.adapter.outbound.repository;

import com.challenge.fastfood.domain.actor.Example;
import com.challenge.fastfood.domain.ports.outbound.SaveExampleAdapterPort;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveExampleAdapter implements SaveExampleAdapterPort {

    private final ExampleRepository exampleRepository;
    @Override
    public Example saveExample(Example example) {

        ExampleEntity exampleEntity = new ExampleEntity();
        exampleEntity.setName(example.getName());
        exampleEntity.setDescription(example.getDescription());

        return exampleRepository.save(exampleEntity).toDomain();
    }
}
