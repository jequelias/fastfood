package com.challenge.fastfood.adapter.out.repository;

import com.challenge.fastfood.adapter.out.mapstruct.LunchItemMapper;
import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.ports.out.SaveLunchItemAdapterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveLunchItemAdapter implements SaveLunchItemAdapterPort {

    private final LunchItemsRepository lunchItemsRepository;
    private final LunchItemMapper lunchItemMapper;

    @Override
    public LunchItem saveLunchItem(LunchItem lunchItem) {
        LunchItemEntity lunchItemEntity = lunchItemMapper.lunchItemToLunchItemEntity(lunchItem);
        lunchItemEntity.setStatus(true);
        LunchItemEntity lunchItemEntitySaved = lunchItemsRepository.save(lunchItemEntity);

        return lunchItemMapper.lunchItemEntityToLunchItem(lunchItemEntitySaved);
    }
}
