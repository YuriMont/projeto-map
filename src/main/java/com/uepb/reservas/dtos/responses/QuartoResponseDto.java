package com.uepb.reservas.dtos.responses;

import com.uepb.reservas.models.Quarto;

public record QuartoResponseDto(
        Long id,
        Long numero,
        Integer tipo,
        Integer status,
        Integer capacidade,
        Double precoDiaria
) {
    public QuartoResponseDto(Quarto quarto){
        this(
                quarto.getId(),
                quarto.getNumero(),
                quarto.getTipo().ordinal(),
                quarto.getStatus().ordinal(),
                quarto.getCapacidade(),
                quarto.getPrecoDiaria()
        );
    }
}
