package com.uepb.reservas.dtos.responses;

import com.uepb.reservas.models.Servico;

public record ServicoResponseDto(
        Long id,
        String descricao,
        String nome,
        Double valor
) {
    public ServicoResponseDto(Servico servico){
        this(
                servico.getId(),
                servico.getDescricao(),
                servico.getNome(),
                servico.getValor()
        );
    }
}
