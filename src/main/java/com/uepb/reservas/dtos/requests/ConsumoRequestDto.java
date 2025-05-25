package com.uepb.reservas.dtos.requests;

import java.util.Date;

public record ConsumoRequestDto(
    String descricao,
    int quantidade,
    Double precoUnitario,
    Date dataConsumo
){}
