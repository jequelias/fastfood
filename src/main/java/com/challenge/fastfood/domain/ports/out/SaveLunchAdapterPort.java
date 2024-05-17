package com.challenge.fastfood.domain.ports.out;

import com.challenge.fastfood.adapter.in.controller.request.LunchRequest;
import com.challenge.fastfood.domain.entities.Lunch;
import com.challenge.fastfood.domain.entities.LunchItem;

import java.util.List;

public interface SaveLunchAdapterPort {

    Lunch saveLunch(LunchRequest lunchRequest);
}
