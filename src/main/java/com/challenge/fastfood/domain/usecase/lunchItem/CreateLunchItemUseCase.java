package com.challenge.fastfood.domain.usecase.lunchItem;

import com.challenge.fastfood.config.exception.LunchItemException;
import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.ports.in.lunchItem.CreateLunchItemUseCasePort;
import com.challenge.fastfood.domain.ports.out.lunchItem.FindLunchItemsAdapterPort;
import com.challenge.fastfood.domain.ports.out.lunchItem.SaveLunchItemAdapterPort;

public class CreateLunchItemUseCase implements CreateLunchItemUseCasePort {

    private final SaveLunchItemAdapterPort saveLunchItemAdapterPort;

    private final FindLunchItemsAdapterPort findLunchItemsAdapterPort;

    public CreateLunchItemUseCase(SaveLunchItemAdapterPort saveLunchItemAdapterPort, FindLunchItemsAdapterPort findLunchItemsAdapterPort) {
        this.saveLunchItemAdapterPort = saveLunchItemAdapterPort;
        this.findLunchItemsAdapterPort = findLunchItemsAdapterPort;
    }

    @Override
    public LunchItem createLunchItem(LunchItem lunchItem) {

        LunchItem lunchItemByName = findLunchItemsAdapterPort.findLunchItemByName(lunchItem.getName());
        if(lunchItemByName != null){
            throw new LunchItemException("LunchItem already exists");
        }

        lunchItem.setStatus(true);

        return saveLunchItemAdapterPort.saveLunchItem(lunchItem);
    }
}
