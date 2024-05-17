package com.challenge.fastfood.adapter.in.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record LunchResponse(
        @Schema(description = "The client CPF", example = "111.111.111-11")
        String cpf,
        @Schema(description = "The total price", example = "142.34")
        Float priceTotal,
        @Schema(description = "The details for the snack of the lunch")
        LunchItemResponse snackResponse,
        @Schema(description = "The details for the drink of the lunch")
        LunchItemResponse drinkResponse,
        @Schema(description = "The details for the accompaniment of the lunch")
        LunchItemResponse accompanimentResponse,
        @Schema(description = "The details for the dessert of the lunch")
        LunchItemResponse dessertResponse) {
}
