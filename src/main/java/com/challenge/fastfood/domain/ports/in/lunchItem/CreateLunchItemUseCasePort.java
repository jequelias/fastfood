package com.challenge.fastfood.domain.ports.in.lunchItem;

import com.challenge.fastfood.domain.entities.LunchItem;

public interface CreateLunchItemUseCasePort {

    LunchItem createLunchItem(LunchItem lunchItem);
}
