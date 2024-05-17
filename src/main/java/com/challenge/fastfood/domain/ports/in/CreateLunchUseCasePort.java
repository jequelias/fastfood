package com.challenge.fastfood.domain.ports.in;

import com.challenge.fastfood.domain.entities.Lunch;

public interface CreateLunchUseCasePort {

    Lunch createLunch(Lunch lunch);
}
