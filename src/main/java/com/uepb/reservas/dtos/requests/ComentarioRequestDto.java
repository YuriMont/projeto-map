package com.uepb.reservas.dtos.requests;

public record ComentarioRequestDto(
        Long id_hospede,
        Long id_reserva,
        String comentario,
        int avaliacao
){}
