package com.challenge.fastfood.adapter.in.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record ClientRequest(
        @Schema(description = "The name of the client", example = "Jequelia")
        String name,
        @Schema(description = "The email of the client", example = "jequelia@email.com")
        String email,
        @Schema(description = "The cpf of the client", example = "123.456.789-00")
        String cpf) {




}
