package com.challenge.fastfood.adapter.in;

import com.challenge.fastfood.adapter.in.controller.request.LunchRequest;
import com.challenge.fastfood.domain.entities.Lunch;
import com.challenge.fastfood.domain.ports.in.lunch.LunchControllerPort;
import com.challenge.fastfood.domain.usecase.lunch.CreateLunchUseCase;
import com.challenge.fastfood.domain.usecase.lunch.FindLunchUseCase;

import java.util.List;

public class LunchControllerAdapter implements LunchControllerPort {

    private final CreateLunchUseCase createLunchUseCase;
    private final FindLunchUseCase findLunchUseCase;

    public LunchControllerAdapter(
            CreateLunchUseCase createLunchUseCase,
            FindLunchUseCase findLunchUseCase) {
        this.createLunchUseCase = createLunchUseCase;
        this.findLunchUseCase = findLunchUseCase;
    }

    @Override
    public Lunch createLunch(LunchRequest lunchRequest) {
        return createLunchUseCase.createLunch(null);
    }

    @Override
    public List<Lunch> findLunchs() {
        return findLunchUseCase.findLunchs();
    }
}
