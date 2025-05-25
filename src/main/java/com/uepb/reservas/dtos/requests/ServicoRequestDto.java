package com.uepb.reservas.dtos.requests;

public record ServicoRequestDto(
    String nome,
    String descricao,
    Double valor
){}
