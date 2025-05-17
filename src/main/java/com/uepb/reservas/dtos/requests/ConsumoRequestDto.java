package com.uepb.reservas.dtos.requests;

import java.util.Date;

public record ConsumoRequestDto(
    Long id_reserva,
    String descricao,
    int quantidade,
    Double precoUnitario,
    Date dataConsumo
){}
