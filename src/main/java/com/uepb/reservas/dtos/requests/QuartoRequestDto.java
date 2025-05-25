package com.uepb.reservas.dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;

public record QuartoRequestDto(

    @Schema(description = "Numero do Quarto", example = "71")
    Long numero,

    @Schema(description = "Tipo do Quarto", example = "2")
    Integer quartoTipo,

    @Schema(description = "Status do Quarto", example = "2")
    Integer quartoStatus,

    @Schema(description = "Capacidade do Quarto", example = "5")
    Integer capacidade,

    @Schema(description = "Preco da diaria do Quarto", example = "600.00")
    Double precoDiaria
){}
