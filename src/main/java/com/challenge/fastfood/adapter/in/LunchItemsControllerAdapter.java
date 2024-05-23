package com.challenge.fastfood.adapter.in;

import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.entities.LunchItemType;
import com.challenge.fastfood.domain.ports.in.lunchItem.LunchItemsControllerPort;
import com.challenge.fastfood.domain.usecase.lunchItem.CreateLunchItemUseCase;
import com.challenge.fastfood.domain.usecase.lunchItem.EditLunchItemUseCase;
import com.challenge.fastfood.domain.usecase.lunchItem.FindLunchItemsUseCase;

import java.util.List;

public class LunchItemsControllerAdapter implements LunchItemsControllerPort {

    private final CreateLunchItemUseCase createLunchItemUseCase;
    private final EditLunchItemUseCase editLunchItemUseCase;
    private final FindLunchItemsUseCase findLunchItemsUseCase;

    public LunchItemsControllerAdapter(
            CreateLunchItemUseCase createLunchItemUseCase,
            EditLunchItemUseCase editLunchItemUseCase,
            FindLunchItemsUseCase findLunchItemsUseCase
    ) {
        this.createLunchItemUseCase = createLunchItemUseCase;
        this.editLunchItemUseCase = editLunchItemUseCase;
        this.findLunchItemsUseCase = findLunchItemsUseCase;
    }

    @Override
    public LunchItem createLunchItem(LunchItem lunchItem) {
        return createLunchItemUseCase.createLunchItem(lunchItem);
    }

    @Override
    public Boolean editStatusLunchItem(Long idLunchItem) {
        return editLunchItemUseCase.editStatusLunchItem(idLunchItem);
    }

    @Override
    public LunchItem editLunchItem(Long idLunchItem, LunchItem lunchItem) {
        return editLunchItemUseCase.editLunchItem(idLunchItem, lunchItem);
    }

    @Override
    public List<LunchItem> findLunchItems(LunchItemType type) {
        return findLunchItemsUseCase.findLunchItems(type);
    }

    @Override
    public LunchItem findLunchItemByName(String name) {
        return findLunchItemsUseCase.findLunchItemByName(name);
    }
}
