package com.challenge.fastfood.domain.ports.out.lunchItem;

import com.challenge.fastfood.adapter.in.controller.request.LunchItemRequest;
import com.challenge.fastfood.adapter.in.controller.response.LunchItemResponse;
import com.challenge.fastfood.domain.entities.LunchItem;

public interface EditLunchItemAdapterPort {

    Boolean editStatusLunchItem(Long idLunchItem,Boolean status);

    LunchItem editLunchItem( LunchItem lunchItem, Long idLunchItem);
}
