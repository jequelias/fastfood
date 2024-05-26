package com.challenge.fastfood.domain.ports.out.lunchItem;

import com.challenge.fastfood.domain.entities.LunchItem;

public interface SaveLunchItemAdapterPort {

    LunchItem saveLunchItem(LunchItem lunchItem);
}
