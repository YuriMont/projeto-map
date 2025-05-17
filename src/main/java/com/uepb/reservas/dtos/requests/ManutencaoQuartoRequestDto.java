package com.uepb.reservas.dtos.requests;

import java.util.Date;

public record ManutencaoQuartoRequestDto(
    Long id_quarto,
    Long id_funcionario,
    String descricao,
    Date dataInicio,
    Date dataFim,
    String status
){}
