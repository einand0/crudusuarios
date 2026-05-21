package com.technando.crudusuarios.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO responsável pela resposta ao criar um usuário")
public record UserResponseDTO(
        Long id,
        String name,
        String email) {
}
