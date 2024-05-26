package com.challenge.fastfood.adapter.out.repository.lunchItem;

import com.challenge.fastfood.adapter.out.mapstruct.LunchItemMapper;
import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.ports.out.lunchItem.SaveLunchItemAdapterPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveLunchItemAdapter implements SaveLunchItemAdapterPort {

    private final LunchItemsRepository lunchItemsRepository;
    private final LunchItemMapper lunchItemMapper;

    @Override
    @Transactional
    public LunchItem saveLunchItem(LunchItem lunchItem) {
        LunchItemEntity lunchItemEntity = lunchItemMapper.lunchItemToLunchItemEntity(lunchItem);
        LunchItemEntity lunchItemEntitySaved = lunchItemsRepository.save(lunchItemEntity);
        return lunchItemMapper.lunchItemEntityToLunchItem(lunchItemEntitySaved);
    }
}
