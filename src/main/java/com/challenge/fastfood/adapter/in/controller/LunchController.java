package com.challenge.fastfood.adapter.in.controller;

import com.challenge.fastfood.adapter.in.controller.request.LunchRequest;
import com.challenge.fastfood.adapter.in.controller.response.LunchResponse;
import com.challenge.fastfood.adapter.out.mapstruct.LunchItemMapper;
import com.challenge.fastfood.adapter.out.mapstruct.LunchMapper;
import com.challenge.fastfood.domain.entities.Client;
import com.challenge.fastfood.domain.entities.Lunch;
import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.ports.in.CreateLunchUseCasePort;
import com.challenge.fastfood.domain.ports.in.FindClientUseCasePort;
import com.challenge.fastfood.domain.ports.in.FindLunchItemsUseCasePort;
import com.challenge.fastfood.domain.valueObjects.Accompaniment;
import com.challenge.fastfood.domain.valueObjects.Dessert;
import com.challenge.fastfood.domain.valueObjects.Drink;
import com.challenge.fastfood.domain.valueObjects.Snack;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lunch")
@Tag(name = "Lunch", description = "Lunch Controller")
@RequiredArgsConstructor
public class LunchController {

    private final CreateLunchUseCasePort createLunchUseCasePort;
    private final FindLunchItemsUseCasePort findLunchItemsUseCasePort;
    private final FindClientUseCasePort findClientUseCasePort;
    private final LunchMapper lunchMapper;
    private final LunchItemMapper lunchItemMapper;

    @PostMapping
    @Operation(summary = "Create a lunch order", description = "Create a lunch order")
    public ResponseEntity<LunchResponse> createLunch(@RequestBody LunchRequest lunchRequest) {
        Client lunchClient = null;
        Snack lunchSnack = null;
        Accompaniment lunchAccompaniment = null;
        Drink lunchDrink = null;
        Dessert lunchDessert = null;
        Lunch lunch = new Lunch(lunchClient, lunchSnack, lunchAccompaniment, lunchDrink, lunchDessert);
        if (lunchRequest.clientId() != null) {
            lunchClient = findClientUseCasePort.findClient(null, lunchRequest.clientId(), null);
            lunch.setClient(lunchClient);
        }
        if (lunchRequest.snack() != null) {
            lunchSnack = (Snack) lunchItemMapper.lunchItemToProduct(findLunchItemsUseCasePort.findLunchItemByName(lunchRequest.snack()));
            lunch.setSnack(lunchSnack);
        }
        if (lunchRequest.accompaniment() != null) {
            lunchAccompaniment = (Accompaniment) lunchItemMapper.lunchItemToProduct(findLunchItemsUseCasePort.findLunchItemByName(lunchRequest.accompaniment()));
            lunch.setAccompaniment(lunchAccompaniment);
        }
        if (lunchRequest.drink() != null) {
            lunchDrink = (Drink) lunchItemMapper.lunchItemToProduct(findLunchItemsUseCasePort.findLunchItemByName(lunchRequest.drink()));
            lunch.setDrink(lunchDrink);
        }
        if (lunchRequest.dessert() != null) {
            lunchDessert = (Dessert) lunchItemMapper.lunchItemToProduct(findLunchItemsUseCasePort.findLunchItemByName(lunchRequest.dessert()));
            lunch.setDessert(lunchDessert);
        }
        Lunch createdLunch = createLunchUseCasePort.createLunch(lunch);
        return ResponseEntity.ok(lunchMapper.lunchToLunchResponse(createdLunch));
    }
}
