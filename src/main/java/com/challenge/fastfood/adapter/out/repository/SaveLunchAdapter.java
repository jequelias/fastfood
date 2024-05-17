package com.challenge.fastfood.adapter.out.repository;

import com.challenge.fastfood.adapter.out.mapstruct.LunchMapper;
import com.challenge.fastfood.domain.entities.Lunch;
import com.challenge.fastfood.domain.ports.out.SaveLunchAdapterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveLunchAdapter implements SaveLunchAdapterPort {

    private final LunchRepository lunchRepository;
    private final LunchMapper lunchMapper;

    @Override
    public Lunch saveLunch(Lunch lunch) {
        LunchEntity lunchEntity = lunchMapper.lunchToLunchEntity(lunch);
        LunchEntity lunchEntitySaved = lunchRepository.save(lunchEntity);

        return lunchMapper.lunchEntityToLunch(lunchEntitySaved);
    }
}
