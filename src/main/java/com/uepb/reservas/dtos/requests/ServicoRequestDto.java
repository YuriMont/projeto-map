package com.uepb.reservas.dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;

public record ServicoRequestDto(

    @Schema(description = "Nome do Serviço", example = "Massagem grega")
    String nome,

    @Schema(description = "Descrição do Serviço", example = "Você recebeu uma massagem grega nos pés.")
    String descricao,

    @Schema(description = "Valor do Serviço", example = "120.00")
    Double valor
){}
