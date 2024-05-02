package com.challenge.fastfood.domain.ports.outbound;

import com.challenge.fastfood.adapter.outbound.repository.ExampleEntity;
import com.challenge.fastfood.domain.actor.Example;

public interface SaveExampleAdapterPort {

    Example saveExample(Example name);
}
