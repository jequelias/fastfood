package com.challenge.fastfood.adapter.out.repository;

import com.challenge.fastfood.adapter.in.controller.request.LunchRequest;
import com.challenge.fastfood.adapter.out.mapstruct.LunchMapper;
import com.challenge.fastfood.config.exception.ClientNotFoundException;
import com.challenge.fastfood.domain.entities.Lunch;
import com.challenge.fastfood.domain.ports.out.SaveLunchAdapterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SaveLunchAdapter implements SaveLunchAdapterPort {

    private final LunchRepository lunchRepository;
    private final LunchItemsRepository lunchItemRepository;
    private final ClientRepository clientRepository;
    private final LunchMapper lunchMapper;

    @Override
    public Lunch saveLunch(LunchRequest lunchRequest) {

        List<LunchItemEntity> lunchItems = new ArrayList<>();
        ClientEntity clientEntity = null;

        mapperLunch(lunchRequest.drink(), lunchItems);
        mapperLunch(lunchRequest.snack(), lunchItems);
        mapperLunch(lunchRequest.accompaniment(), lunchItems);
        mapperLunch(lunchRequest.dessert(), lunchItems);

        clientEntity = getClientEntity(lunchRequest, clientEntity);

        LunchEntity lunch = new LunchEntity();
        lunch.setLunchItems(lunchItems);
        lunch.setClient(clientEntity);
        lunch.setStatus("PENDENTE");

        LunchEntity lunchEntitySaved = lunchRepository.save(lunch);

        return lunchMapper.lunchEntityToLunch(lunchEntitySaved);
    }

    private ClientEntity getClientEntity(LunchRequest lunchRequest, ClientEntity clientEntity) {
        if(lunchRequest.clientId() != null) {
            clientEntity = clientRepository.findById(lunchRequest.clientId()).orElseThrow(() -> new ClientNotFoundException("Client not found." ));
        }
        return clientEntity;
    }

    private void mapperLunch(List<Long> lunchRequest, List<LunchItemEntity> lunchItems) {
        for (Long lunchItem : lunchRequest) {
            lunchItemRepository.findById(lunchItem).ifPresent(lunchItems::add);
        }
    }
}
