package com.challenge.fastfood.domain.ports.out;

import com.challenge.fastfood.domain.entities.LunchItem;

public interface SaveLunchItemAdapterPort {

    LunchItem saveLunchItem(LunchItem lunchItem);
}
