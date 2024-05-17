package com.challenge.fastfood.domain.ports.in;

import com.challenge.fastfood.domain.entities.Lunch;

import java.util.List;

public interface FindLunchUseCasePort {

    List<Lunch> findLunchs();
}
