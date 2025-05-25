package com.uepb.reservas.dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;

public record PagamentoRequestDto(

    @Schema(description = "ID da Reserva", example = "20123")
    Long id_reserva,

    @Schema(description = "Forma de Pagamento", example = "4")
    Integer formaPagamento
){}
