package com.challenge.fastfood.domain.ports.in.lunchItem;

import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.entities.LunchItemType;

import java.util.List;

public interface LunchItemsControllerPort {

    LunchItem createLunchItem(LunchItem lunchItem);
    Boolean editStatusLunchItem(Long idLunchItem, Boolean status);
    LunchItem editLunchItem(Long idLunchItem, LunchItem lunchItem);
    List<LunchItem> findLunchItems(LunchItemType type);
    LunchItem findLunchItemByName(String name);
}
