package com.challenge.fastfood.domain.usecase.lunch;

import com.challenge.fastfood.adapter.in.controller.request.LunchRequest;
import com.challenge.fastfood.config.exception.LunchItemException;
import com.challenge.fastfood.domain.entities.Lunch;
import com.challenge.fastfood.domain.ports.in.lunch.CreateLunchUseCasePort;
import com.challenge.fastfood.domain.ports.out.lunch.SaveLunchAdapterPort;

public class CreateLunchUseCase implements CreateLunchUseCasePort {

    private final SaveLunchAdapterPort saveLunchAdapterPort;

    public CreateLunchUseCase(SaveLunchAdapterPort saveLunchAdapterPort) {
        this.saveLunchAdapterPort = saveLunchAdapterPort;
    }

    @Override
    public Lunch createLunch(Lunch lunch) {

        if(lunch.getClient() == null || lunch.getClient().getId() == 0){
            throw new LunchItemException("id Client are required");
        }

        return saveLunchAdapterPort.saveLunch(lunch);
    }
}
