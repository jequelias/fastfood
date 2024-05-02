package com.challenge.fastfood.domain.ports.inbound;

import com.challenge.fastfood.adapter.outbound.repository.ExampleEntity;
import com.challenge.fastfood.domain.actor.Example;

public interface CreateExampleUseCasePort {

    Example createExample(Example example);

}
