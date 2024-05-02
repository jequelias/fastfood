package com.challenge.fastfood.domain.ports.outbound;

import com.challenge.fastfood.domain.actor.Example;

public interface FindExampleAdapterPort {
    Example findExample(String name);
}
