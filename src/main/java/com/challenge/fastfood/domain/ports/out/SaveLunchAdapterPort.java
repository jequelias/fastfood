package com.challenge.fastfood.domain.ports.out;

import com.challenge.fastfood.domain.entities.Lunch;

public interface SaveLunchAdapterPort {

    Lunch saveLunch(Lunch lunch);
}
