package com.challenge.fastfood.domain.ports.outbound;

import com.challenge.fastfood.domain.actor.Client;

public interface FindClientAdapterPort {
    Client findClient(String name);
}
