package com.challenge.fastfood.adapter.out.mapstruct;

import com.challenge.fastfood.adapter.in.controller.response.LunchResponse;
import com.challenge.fastfood.adapter.out.repository.LunchEntity;
import com.challenge.fastfood.domain.entities.Lunch;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LunchMapper {

    Lunch lunchEntityToLunch(LunchEntity lunchEntity);

    LunchResponse lunchToLunchResponse(Lunch lunch);

    LunchEntity lunchToLunchEntity(Lunch lunch);
}
