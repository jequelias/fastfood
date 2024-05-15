package com.challenge.fastfood.adapter.in.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record LunchItemRequest(
        @Schema(description = "The name of the lunch item", example = "Hamburger")
        String name,
        @Schema(description = "The price of the lunch item with two decimal points", example = "12.34")
        Float price,
        @Schema(description = "The type of the lunch item", example = "snack")
        String type) {
}
