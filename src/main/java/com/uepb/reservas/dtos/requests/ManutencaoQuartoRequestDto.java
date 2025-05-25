package com.uepb.reservas.dtos.requests;

import java.time.LocalDateTime;
import java.util.Date;

public record ManutencaoQuartoRequestDto(
    Long id_quarto,
    Long id_funcionario,
    String descricao,
    LocalDateTime dataInicio,
    LocalDateTime dataFim,
    Integer status
){}
