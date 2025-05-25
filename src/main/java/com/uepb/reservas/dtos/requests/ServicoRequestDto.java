package com.uepb.reservas.dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;

public record ServicoRequestDto(

    @Schema(description = "Nome do Servico", example = "Massagem grega")
    String nome,

    @Schema(description = "Descricao do Servico", example = "Voce recebe uma massagem grega nos pes")
    String descricao,

    @Schema(description = "Valor do Servico", example = "120.00")
    Double valor
){}
