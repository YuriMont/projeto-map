package com.uepb.reservas.dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;

public record ComentarioRequestDto(
        
        @Schema(description = "ID do Hospede", example = "16")
        Long id_hospede,

        @Schema(description = "ID da Reserva", example = "200")
        Long id_reserva,

        @Schema(description = "Comentario sobre a hospedagem", example = "nossa foi uma delicia")
        String comentario,

        @Schema(description = "Avaliacao", example = "5")
        int avaliacao
){}
