package com.challenge.fastfood.adapter.in.controller.request;

import com.challenge.fastfood.domain.entities.LunchItemType;
import io.swagger.v3.oas.annotations.media.Schema;

public record LunchItemEditRequest(

        @Schema(description = "The price of the lunch item with two decimal points", example = "12.34")
        Float price,
        @Schema(description = "The type of the lunch item", example = "SNACK, ACCOMPANIMENT, DRINK, DESSERT")
        LunchItemType type){
}
