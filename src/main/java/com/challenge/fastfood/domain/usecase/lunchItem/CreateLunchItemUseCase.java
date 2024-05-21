package com.challenge.fastfood.domain.usecase.lunchItem;

import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.ports.in.lunchItem.CreateLunchItemUseCasePort;
import com.challenge.fastfood.domain.ports.out.lunchItem.SaveLunchItemAdapterPort;

public class CreateLunchItemUseCase implements CreateLunchItemUseCasePort {

    private final SaveLunchItemAdapterPort saveLunchItemAdapterPort;

    public CreateLunchItemUseCase(SaveLunchItemAdapterPort saveLunchItemAdapterPort) {
        this.saveLunchItemAdapterPort = saveLunchItemAdapterPort;
    }

    @Override
    public LunchItem createLunchItem(LunchItem lunchItem) {
        return saveLunchItemAdapterPort.saveLunchItem(lunchItem);
    }
}
