package com.uepb.reservas.dtos.responses;

import com.uepb.reservas.models.Pagamento;

public record PagamentoResponseDto(
        Long id,
        Long reservaId,
        Double valorPago,
        Integer formaPagamento
) {
    public PagamentoResponseDto(Pagamento pagamento){
        this(
               pagamento.getId(),
               pagamento.getReserva().getId(),
               pagamento.getValorPago(),
               pagamento.getFormaPagamento().ordinal()
        );
    }

}
