package com.challenge.fastfood.domain.usecase.lunch;

import com.challenge.fastfood.domain.entities.Lunch;
import com.challenge.fastfood.domain.ports.in.lunch.FindLunchUseCasePort;
import com.challenge.fastfood.domain.ports.out.lunch.FindLunchAdapterPort;

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
