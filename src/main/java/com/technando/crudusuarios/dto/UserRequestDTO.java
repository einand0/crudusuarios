package com.technando.crudusuarios.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO para criação de usuários")
public record UserRequestDTO(

        @Schema(
                description = "Nome do usuário",
                example = "João"
        )
        @NotBlank String name,

        @Schema(
                description = "E-mail do usuário",
                example = "joao@email.com"
        )
        @NotBlank @Email(message = "E-mail inválido") String email,

        @Schema(
                description = "Senha do usuário",
                example = "123"
        )
        @NotBlank String password){}
