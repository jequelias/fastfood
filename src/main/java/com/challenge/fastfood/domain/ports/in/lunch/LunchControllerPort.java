package com.challenge.fastfood.domain.ports.in.lunch;

import com.challenge.fastfood.adapter.in.controller.request.LunchRequest;
import com.challenge.fastfood.domain.entities.Lunch;

import java.util.List;

public interface LunchControllerPort {
    Lunch createLunch(LunchRequest lunchRequest);
    List<Lunch> findLunchs();
}
