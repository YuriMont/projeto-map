package com.uepb.reservas.dtos.responses;

import com.uepb.reservas.models.Reserva;

import java.time.LocalDateTime;
import java.util.List;

public record ReservaResponseDto(
        Long id,
        LocalDateTime dataCheckin,
        LocalDateTime dataCheckout,
        Integer status,
        Long hospedeId,
        Long quartoId,
        Long pagamentoId,
        List<ServicoResponseDto> servicos,
        List<ConsumoResponseDto> consumos
) {
    public ReservaResponseDto(Reserva reserva){
        this(
                reserva.getId(),
                reserva.getDataCheckin(),
                reserva.getDataCheckout(),
                reserva.getStatus().ordinal(),
                reserva.getHospede().getId(),
                reserva.getQuarto().getId(),
                reserva.getPagamento().getId(),
                reserva.getServicos().stream().map(item -> new ServicoResponseDto(item)).toList(),
                reserva.getConsumos().stream().map(item -> new ConsumoResponseDto(item)).toList()
        );
    }
}
