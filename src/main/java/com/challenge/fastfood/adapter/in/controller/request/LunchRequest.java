package com.challenge.fastfood.adapter.in.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record LunchRequest(
        @Schema(description = "The client's identification", example = "Patrícia or 111.111.111-11 or patricia@fastfood.com", nullable = true)
        String clientId,
        @Schema(description = "The lunch snack", example = "Hamburger", nullable = true)
        String snack,
        @Schema(description = "The lunch drink", example = "Milkshake", nullable = true)
        String drink,
        @Schema(description = "The lunch accompaniment", example = "Fries", nullable = true)
        String accompaniment,
        @Schema(description = "The lunch dessert", example = "Ice-cream", nullable = true)
        String dessert
) {
}
