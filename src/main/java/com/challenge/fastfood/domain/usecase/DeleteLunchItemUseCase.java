package com.challenge.fastfood.domain.usecase;

import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.ports.in.CreateLunchItemUseCasePort;
import com.challenge.fastfood.domain.ports.in.DeleteLunchItemUseCasePort;
import com.challenge.fastfood.domain.ports.out.DeleteLunchItemAdapterPort;
import com.challenge.fastfood.domain.ports.out.SaveLunchAdapterPort;
import com.challenge.fastfood.domain.ports.out.SaveLunchItemAdapterPort;

public class DeleteLunchItemUseCase implements DeleteLunchItemUseCasePort {

    private final DeleteLunchItemAdapterPort deleteLunchItemAdapterPort;

    public DeleteLunchItemUseCase(DeleteLunchItemAdapterPort deleteLunchItemAdapterPort) {
        this.deleteLunchItemAdapterPort = deleteLunchItemAdapterPort;
    }

    @Override
    public Boolean deleteLunchItem(Long idLunchItem) {
        return deleteLunchItemAdapterPort.deleteLunchItem(idLunchItem);
    }
}
