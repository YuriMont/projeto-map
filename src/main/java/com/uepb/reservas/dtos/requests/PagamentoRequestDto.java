package com.uepb.reservas.dtos.requests;

import com.uepb.reservas.enums.FormaPagamento;

import io.swagger.v3.oas.annotations.media.Schema;

public record PagamentoRequestDto(

    @Schema(description = "ID da Reserva", example = "20123")
    Long id_reserva,

    @Schema(description = "Forma de pagamento", example = "4")
    Integer formaPagamento
){}
