package com.challenge.fastfood.domain.ports.in.lunch;

import com.challenge.fastfood.domain.entities.Lunch;

import java.util.List;

public interface FindLunchUseCasePort {

    List<Lunch> findLunchs();
    Lunch findLunchById(Long id);
}
