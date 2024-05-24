package com.challenge.fastfood.domain.ports.out.lunch;

import com.challenge.fastfood.domain.entities.Lunch;

import java.util.List;

public interface FindLunchAdapterPort {

    List<Lunch> findLunchs();
    Lunch findLunchById(Long id);
}
