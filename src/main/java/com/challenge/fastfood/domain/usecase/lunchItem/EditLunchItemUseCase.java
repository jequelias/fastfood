package com.challenge.fastfood.domain.usecase.lunchItem;

import com.challenge.fastfood.adapter.in.controller.request.LunchItemRequest;
import com.challenge.fastfood.adapter.in.controller.response.LunchItemResponse;
import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.ports.in.lunchItem.EditLunchItemUseCasePort;
import com.challenge.fastfood.domain.ports.out.lunchItem.EditLunchItemAdapterPort;

public class EditLunchItemUseCase implements EditLunchItemUseCasePort {

    private final EditLunchItemAdapterPort editLunchItemAdapterPort;

    public EditLunchItemUseCase(EditLunchItemAdapterPort editLunchItemAdapterPort) {
        this.editLunchItemAdapterPort = editLunchItemAdapterPort;
    }

    @Override
    public Boolean editStatusLunchItem(Long idLunchItem) {
        return editLunchItemAdapterPort.editStatusLunchItem(idLunchItem);
    }

    @Override
    public LunchItem editLunchItem(Long idLunchItem, LunchItem lunchItem) {
        return editLunchItemAdapterPort.editLunchItem(idLunchItem, lunchItem);
    }

}
