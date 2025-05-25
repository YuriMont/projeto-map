package com.uepb.reservas.dtos.responses;

import com.uepb.reservas.models.ManutencaoQuarto;

public record ManutencaoQuartoResponseDto(
        Long id,
        Long quartoId,
        Long funcionarioId,
        String descricao,
        Integer status
) {
    public ManutencaoQuartoResponseDto(ManutencaoQuarto manutencaoQuarto){
        this(
             manutencaoQuarto.getId(),
             manutencaoQuarto.getQuarto().getId(),
             manutencaoQuarto.getFuncionario().getId(),
             manutencaoQuarto.getDescricao(),
             manutencaoQuarto.getStatus().ordinal()
        );
    }
}
