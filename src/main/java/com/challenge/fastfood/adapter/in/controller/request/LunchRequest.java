package com.challenge.fastfood.adapter.in.controller.request;

import com.challenge.fastfood.domain.entities.LunchItem;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record LunchRequest(
        @Schema(description = "The client's identification", example = "Patrícia or 111.111.111-11 or patricia@fastfood.com", nullable = true)
        Long clientId,
        @Schema(description = "The lunch snack", example = "Hamburger", nullable = true)
        List<Long> snack,
        @Schema(description = "The lunch drink", example = "Milkshake", nullable = true)
        List<Long> drink,
        @Schema(description = "The lunch accompaniment", example = "Fries", nullable = true)
        List<Long> accompaniment,
        @Schema(description = "The lunch dessert", example = "Ice-cream", nullable = true)
        List<Long> dessert
) {

}
