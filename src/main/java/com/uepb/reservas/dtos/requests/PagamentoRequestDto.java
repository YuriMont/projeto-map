package com.uepb.reservas.dtos.requests;

import com.uepb.reservas.enums.FormaPagamento;

public record PagamentoRequestDto(
    Long id_reserva,
    Double valorPago,
    FormaPagamento formaPagamento
){}
