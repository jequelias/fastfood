package com.challenge.fastfood.domain.usecase;

import com.challenge.fastfood.domain.entities.Lunch;
import com.challenge.fastfood.domain.ports.in.CreateLunchUseCasePort;
import com.challenge.fastfood.domain.ports.out.SaveLunchAdapterPort;

public class CreateLunchUseCase implements CreateLunchUseCasePort {

    private final SaveLunchAdapterPort saveLunchAdapterPort;

    public CreateLunchUseCase(SaveLunchAdapterPort saveLunchAdapterPort) {
        this.saveLunchAdapterPort = saveLunchAdapterPort;
    }

    @Override
    public Lunch createLunch(Lunch lunch) {
        return saveLunchAdapterPort.saveLunch(lunch);
    }
}
