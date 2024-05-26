package com.challenge.fastfood.domain.ports.out.lunchItem;

import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.entities.LunchItemType;

import java.util.List;

public interface FindLunchItemsAdapterPort {

    List<LunchItem> findLunchItems(LunchItemType lunchItemType);
    LunchItem findLunchItemByName(String name);
    LunchItem findLunchItemById(Long id);
}
