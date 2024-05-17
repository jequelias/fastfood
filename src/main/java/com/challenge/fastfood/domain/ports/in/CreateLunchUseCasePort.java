package com.challenge.fastfood.domain.ports.in;

import com.challenge.fastfood.adapter.in.controller.request.LunchRequest;
import com.challenge.fastfood.domain.entities.Lunch;
import com.challenge.fastfood.domain.entities.LunchItem;

import java.util.List;

public interface CreateLunchUseCasePort {

    Lunch createLunch(LunchRequest lunchRequest);
}
