package com.uepb.reservas.dtos.requests;

public record ServicoRequestDto(
    Long id_reserva,
    String nome,
    String descricao,
    Double valor
){}
