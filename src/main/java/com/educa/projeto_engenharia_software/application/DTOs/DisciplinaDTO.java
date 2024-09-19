package com.educa.projeto_engenharia_software.application.DTOs;

import jakarta.validation.constraints.NotNull;

public record DisciplinaDTO(
        String nome,
        long professorId
) {
}
