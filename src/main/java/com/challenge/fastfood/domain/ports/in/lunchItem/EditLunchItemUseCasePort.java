package com.challenge.fastfood.domain.ports.in.lunchItem;

import com.challenge.fastfood.adapter.in.controller.request.LunchItemRequest;
import com.challenge.fastfood.adapter.in.controller.response.LunchItemResponse;
import com.challenge.fastfood.domain.entities.LunchItem;

public interface EditLunchItemUseCasePort {

    Boolean editStatusLunchItem(Long idLunchItem);

    LunchItem editLunchItem(Long idLunchItem, LunchItem lunchItem);
}
