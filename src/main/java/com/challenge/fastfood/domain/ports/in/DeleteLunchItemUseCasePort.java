package com.challenge.fastfood.domain.ports.in;

import com.challenge.fastfood.domain.entities.LunchItem;

public interface DeleteLunchItemUseCasePort {

    Boolean deleteLunchItem(Long idLunchItem);
}
