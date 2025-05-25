package com.uepb.reservas.dtos.requests;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;

public record ConsumoRequestDto(

    @Schema(description = "Descricao do consumo", example = "Coca-Cola Zero")
    String descricao,

    @Schema(description = "Quantidade do consumo", example = "10")
    Integer quantidade,

    @Schema(description = "Preço do consumo", example = "12.00")
    Double precoUnitario,

    @Schema(description = "Data consumo", example = "16/03/2000")
    Date dataConsumo
){}
