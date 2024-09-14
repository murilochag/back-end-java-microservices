package com.murilo.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UserDto(
        @NotBlank(message = "nome é obrigatório")
        String nome,
        @NotBlank(message = "cpf é obrigatório")
        String cpf,
        String endereco,
        @NotBlank(message = "e-mail é obrigatório")
        String email,
        @NotBlank(message = "telefone é obrigatório")
        String telefone,
        LocalDateTime dataCadastro

) {
}
