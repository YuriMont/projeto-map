package com.uepb.reservas.dtos.responses;

import com.uepb.reservas.models.Consumo;

public record ConsumoResponseDto(
        Long id,
        String descricao,
        Integer quantidade,
        Double precoUnitario
) {
    public ConsumoResponseDto(Consumo consumo){
        this(
                consumo.getId(),
                consumo.getDescricao(),
                consumo.getQuantidade(),
                consumo.getPrecoUnitario()
        );
    }

}
