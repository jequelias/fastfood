package com.challenge.fastfood.domain.usecase;

import com.challenge.fastfood.adapter.in.controller.request.LunchRequest;
import com.challenge.fastfood.domain.entities.Lunch;
import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.ports.in.CreateLunchUseCasePort;
import com.challenge.fastfood.domain.ports.out.SaveLunchAdapterPort;

import java.util.List;

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
