package com.technando.crudusuarios.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank String name,
        @NotBlank @Email(message = "E-mail inválido") String email,
        @NotBlank String password){}
