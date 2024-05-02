package com.challenge.fastfood.domain.ports.outbound;

import com.challenge.fastfood.domain.actor.Client;

public interface SaveClientAdapterPort {

    Client saveClient(Client name);
}
