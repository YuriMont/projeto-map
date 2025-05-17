package com.uepb.reservas.dtos.requests;

import com.uepb.reservas.enums.QuartoTipo;
import com.uepb.reservas.enums.QuartoStatus;

public record QuartoRequestDto(
    long numero,
    QuartoTipo tipo,
    QuartoStatus status,
    Integer capacidade,
    Double precoDiaria
){}
