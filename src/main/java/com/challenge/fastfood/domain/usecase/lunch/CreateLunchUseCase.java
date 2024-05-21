package com.challenge.fastfood.domain.usecase.lunch;

import com.challenge.fastfood.adapter.in.controller.request.LunchRequest;
import com.challenge.fastfood.domain.entities.Lunch;
import com.challenge.fastfood.domain.ports.in.lunch.CreateLunchUseCasePort;
import com.challenge.fastfood.domain.ports.out.lunch.SaveLunchAdapterPort;

public class CreateLunchUseCase implements CreateLunchUseCasePort {

    private final SaveLunchAdapterPort saveLunchAdapterPort;

    public CreateLunchUseCase(SaveLunchAdapterPort saveLunchAdapterPort) {
        this.saveLunchAdapterPort = saveLunchAdapterPort;
    }

    @Override
    public Lunch createLunch(LunchRequest lunchRequest) {
        return saveLunchAdapterPort.saveLunch(lunchRequest);
    }
}
