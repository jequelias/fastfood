package com.challenge.fastfood.adapter.out.mapstruct;

import com.challenge.fastfood.adapter.in.controller.response.LunchResponse;
import com.challenge.fastfood.adapter.out.repository.lunch.LunchEntity;
import com.challenge.fastfood.domain.entities.Lunch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LunchMapper {

    Lunch lunchEntityToLunch(LunchEntity lunchEntity);

    List<Lunch> lunchsEntityToLunchs(List<LunchEntity> lunchEntity);

    @Mapping(target = "cpf", source = "lunch.client.cpf")
    @Mapping(target = "numberLunch", source = "lunch.id")
    LunchResponse lunchToLunchResponse(Lunch lunch);

    @Mapping(target = "cpf", source = "lunch.client.cpf")
    @Mapping(target = "numberLunch", source = "lunch.id")
    List<LunchResponse> lunchsToLunchsResponse(List<Lunch> lunch);

}
