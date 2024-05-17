package com.challenge.fastfood.domain.usecase;

import com.challenge.fastfood.adapter.in.controller.request.LunchRequest;
import com.challenge.fastfood.domain.entities.Lunch;
import com.challenge.fastfood.domain.ports.in.FindLunchUseCasePort;
import com.challenge.fastfood.domain.ports.out.FindLunchAdapterPort;
import com.challenge.fastfood.domain.ports.out.SaveLunchAdapterPort;

import java.util.List;

public class FindLunchUseCase implements FindLunchUseCasePort {

    private final FindLunchAdapterPort findLunchAdapterPort;

    public FindLunchUseCase(FindLunchAdapterPort saveLunchAdapterPort) {
        this.findLunchAdapterPort = saveLunchAdapterPort;
    }

    @Override
    public List<Lunch> findLunchs() {
       return findLunchAdapterPort.findLunchs();
    }
}
