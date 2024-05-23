package com.challenge.fastfood.adapter.out.repository.lunchItem;

import com.challenge.fastfood.adapter.out.mapstruct.LunchItemMapper;
import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.entities.LunchItemType;
import com.challenge.fastfood.domain.ports.out.lunchItem.FindLunchItemsAdapterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindLunchItemsAdapter implements FindLunchItemsAdapterPort {

    private final LunchItemsRepository lunchItemsRepository;
    private final LunchItemMapper lunchItemMapper;

    @Override
    public List<LunchItem> findLunchItems(LunchItemType type) {
        List<LunchItemEntity> lunchItemEntity = lunchItemsRepository.findByTypeAndStatusTrue(type);
        return lunchItemMapper.lunchItemEntityToLunchItem(lunchItemEntity);
    }

    @Override
    public LunchItem findLunchItemByName(String name) {
        LunchItemEntity lunchItemEntity = lunchItemsRepository.findByNameAndStatusTrue(name);
        return lunchItemMapper.lunchItemEntityToLunchItem(lunchItemEntity);
    }

    @Override
    public LunchItem findLunchItemById(Long id) {
        LunchItemEntity lunchItemEntity = lunchItemsRepository.findByIdAndStatusTrue(id);
        return lunchItemMapper.lunchItemEntityToLunchItem(lunchItemEntity);
    }

}
