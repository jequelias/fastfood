package com.challenge.fastfood.domain.usecase.lunchItem;

import com.challenge.fastfood.adapter.in.controller.request.LunchItemRequest;
import com.challenge.fastfood.adapter.in.controller.response.LunchItemResponse;
import com.challenge.fastfood.adapter.out.repository.lunchItem.FindLunchItemsAdapter;
import com.challenge.fastfood.config.exception.LunchItemException;
import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.ports.in.lunchItem.EditLunchItemUseCasePort;
import com.challenge.fastfood.domain.ports.out.lunchItem.EditLunchItemAdapterPort;

public class EditLunchItemUseCase implements EditLunchItemUseCasePort {

    private final EditLunchItemAdapterPort editLunchItemAdapterPort;
    private final FindLunchItemsAdapter findLunchItemsAdapter;

    public EditLunchItemUseCase(EditLunchItemAdapterPort editLunchItemAdapterPort, FindLunchItemsAdapter findLunchItemsAdapter) {
        this.editLunchItemAdapterPort = editLunchItemAdapterPort;
        this.findLunchItemsAdapter = findLunchItemsAdapter;
    }

    @Override
    public Boolean editStatusLunchItem(Long idLunchItem, Boolean status) {

        if (idLunchItem == null || status == null) {
            throw new LunchItemException("idLunchItem and status are required");
        }

        LunchItem lunchItem = findLunchItemsAdapter.findLunchItemById(idLunchItem);

        if (lunchItem == null) {
            throw new LunchItemException("Lunch item not found");
        }

        if (status == lunchItem.getStatus()) {
            throw new LunchItemException("Status is already " + status);
        }

        if (status) {
            throw new LunchItemException("Status can't be true");
        }

        return editLunchItemAdapterPort.editStatusLunchItem(idLunchItem, status);
    }

    @Override
    public LunchItem editLunchItem(Long idLunchItem, LunchItem lunchItem) {

        if (idLunchItem == null || lunchItem == null) {
            throw new LunchItemException("idLunchItem and lunchItem are required");
        }

        LunchItem lunchItemById = findLunchItemsAdapter.findLunchItemById(idLunchItem);

        if (lunchItemById == null) {
            throw new LunchItemException("Lunch item not found");
        }

        if (lunchItem.getName() == null
                || lunchItem.getPrice() == null
                || lunchItem.getType() == null) {
            throw new LunchItemException("Name, price and type are required");
        }

        if (lunchItem.getPrice() <= 0) {
            throw new LunchItemException("Price must be greater than 0");
        }

        if (lunchItem.getName().equals(lunchItemById.getName())
                && lunchItem.getPrice().equals(lunchItemById.getPrice())
                && lunchItem.getType().equals(lunchItemById.getType())) {
            throw new LunchItemException("Lunch item is already updated");
        }

        return editLunchItemAdapterPort.editLunchItem(lunchItem);
    }

}
