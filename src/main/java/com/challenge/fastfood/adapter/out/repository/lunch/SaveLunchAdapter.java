package com.challenge.fastfood.adapter.out.repository.lunch;

import com.challenge.fastfood.adapter.out.mapstruct.LunchItemMapper;
import com.challenge.fastfood.adapter.out.mapstruct.LunchMapper;
import com.challenge.fastfood.adapter.out.repository.lunchItem.LunchItemEntity;
import com.challenge.fastfood.adapter.out.repository.client.ClientEntity;
import com.challenge.fastfood.adapter.out.repository.client.ClientRepository;
import com.challenge.fastfood.domain.entities.Lunch;
import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.ports.out.lunch.SaveLunchAdapterPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SaveLunchAdapter implements SaveLunchAdapterPort {

    private final LunchRepository lunchRepository;
    private final ClientRepository clientRepository;
    private final LunchMapper lunchMapper;
    private final LunchItemMapper lunchItemMapper;

    @Override
    @Transactional
    public Lunch saveLunch(Lunch lunch) {

        List<LunchItemEntity> lunchItems = new ArrayList<>();
        ClientEntity clientEntity = null;

        for(LunchItem item : lunch.getLunchItems()){
            LunchItemEntity lunchItemEntity = lunchItemMapper.lunchItemToLunchItemEntity(item);
            lunchItems.add(lunchItemEntity);
        }


        clientEntity = getClientEntity(lunch, clientEntity);

        LunchEntity lunchEntity = new LunchEntity();
        lunchEntity.setLunchItems(lunchItems);
        lunchEntity.setClient(clientEntity);
        lunchEntity.setStatus("PENDENTE");
        double price = 0;
        for (LunchItemEntity lunchItem : lunchItems) {
            price += lunchItem.getPrice();
        }
        lunchEntity.setPriceTotal(price);
        LunchEntity lunchEntitySaved = lunchRepository.save(lunchEntity);

        return lunchMapper.lunchEntityToLunch(lunchEntitySaved);
    }

    private ClientEntity getClientEntity(Lunch lunch, ClientEntity clientEntity) {
        if(lunch.getClient() != null && lunch.getClient().getId() != null) {
            clientEntity = clientRepository.findById(lunch.getClient().getId() ).orElse(null);
        }
        return clientEntity;
    }


}
