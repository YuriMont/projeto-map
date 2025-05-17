package com.uepb.reservas.dtos.requests;

import java.util.Date;

public record ComentarioRequestDto(
        Long id_hospede,
        Long id_reserva,
        String comentario,
        int avaliacao,
        Date dataComentario
){}
