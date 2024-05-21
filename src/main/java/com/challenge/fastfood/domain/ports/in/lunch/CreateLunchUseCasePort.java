package com.challenge.fastfood.domain.ports.in.lunch;

import com.challenge.fastfood.adapter.in.controller.request.LunchRequest;
import com.challenge.fastfood.domain.entities.Lunch;

public interface CreateLunchUseCasePort {

    Lunch createLunch(LunchRequest lunchRequest);
}
