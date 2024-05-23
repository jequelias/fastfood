package com.challenge.fastfood.adapter.in;

import com.challenge.fastfood.adapter.in.controller.request.LunchRequest;
import com.challenge.fastfood.adapter.out.repository.client.ClientEntity;
import com.challenge.fastfood.adapter.out.repository.lunchItem.LunchItemEntity;
import com.challenge.fastfood.domain.entities.Client;
import com.challenge.fastfood.domain.entities.Lunch;
import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.ports.in.lunch.LunchControllerPort;
import com.challenge.fastfood.domain.ports.out.lunch.FindLunchAdapterPort;
import com.challenge.fastfood.domain.ports.out.lunchItem.FindLunchItemsAdapterPort;
import com.challenge.fastfood.domain.usecase.lunch.CreateLunchUseCase;
import com.challenge.fastfood.domain.usecase.lunch.FindLunchUseCase;

import java.util.ArrayList;
import java.util.List;

public class LunchControllerAdapter implements LunchControllerPort {

    private final CreateLunchUseCase createLunchUseCase;
    private final FindLunchUseCase findLunchUseCase;
    private final FindLunchItemsAdapterPort findLunchItemsAdapterPort;

    public LunchControllerAdapter(
            CreateLunchUseCase createLunchUseCase,
            FindLunchUseCase findLunchUseCase, FindLunchItemsAdapterPort findLunchAdapterPort) {
        this.createLunchUseCase = createLunchUseCase;
        this.findLunchUseCase = findLunchUseCase;
        this.findLunchItemsAdapterPort = findLunchAdapterPort;
    }

    @Override
    public Lunch createLunch(LunchRequest lunchRequest) {

        List<LunchItem> lunchItems = new ArrayList<>();

        mapperLunch(lunchRequest.drink(), lunchItems);
        mapperLunch(lunchRequest.snack(), lunchItems);
        mapperLunch(lunchRequest.accompaniment(), lunchItems);
        mapperLunch(lunchRequest.dessert(), lunchItems);

        Lunch lunch = new Lunch();
        Client client = new Client();
        client.setId(lunchRequest.clientId());
        lunch.setLunchItems(lunchItems);
        lunch.setClient(client);

        return createLunchUseCase.createLunch(lunch);
    }

    private void mapperLunch(List<Long> lunchRequest, List<LunchItem> lunchItems) {
        for (Long lunchItem : lunchRequest) {
            LunchItem itemById = findLunchItemsAdapterPort.findLunchItemById(lunchItem);
            if (itemById != null){
                lunchItems.add(itemById);
            }
        }
    }

    @Override
    public List<Lunch> findLunchs() {
        return findLunchUseCase.findLunchs();
    }
}
