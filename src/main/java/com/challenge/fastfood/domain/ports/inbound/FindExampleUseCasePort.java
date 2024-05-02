package com.challenge.fastfood.domain.ports.inbound;

import com.challenge.fastfood.domain.actor.Example;

public interface FindExampleUseCasePort {

    Example findExample(String name);
}
