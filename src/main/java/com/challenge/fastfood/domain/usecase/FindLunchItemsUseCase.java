package com.challenge.fastfood.domain.usecase;

import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.entities.LunchItemType;
import com.challenge.fastfood.domain.ports.in.FindLunchItemsUseCasePort;
import com.challenge.fastfood.domain.ports.out.FindLunchItemsAdapterPort;

import java.util.List;

public class FindLunchItemsUseCase implements FindLunchItemsUseCasePort {

    private final FindLunchItemsAdapterPort findLunchItemsAdapterPort;

    public FindLunchItemsUseCase(FindLunchItemsAdapterPort findLunchItemsAdapterPort) {
        this.findLunchItemsAdapterPort = findLunchItemsAdapterPort;
    }

    @Override
    public List<LunchItem> findLunchItems(LunchItemType type) {
        return findLunchItemsAdapterPort.findLunchItems(type);
    }

    @Override
    public LunchItem findLunchItemByName(String name) {
        return findLunchItemsAdapterPort.findLunchItemByName(name);
    }
}
