package com.challenge.fastfood.domain.ports.out.lunch;

import com.challenge.fastfood.adapter.in.controller.request.LunchRequest;
import com.challenge.fastfood.domain.entities.Lunch;

public interface SaveLunchAdapterPort {

    Lunch saveLunch(Lunch lunch);
}
