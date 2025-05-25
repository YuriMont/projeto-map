package com.uepb.reservas.dtos.responses;

import com.uepb.reservas.models.Comentario;

import java.time.LocalDateTime;

public record ComentarioResponseDto(
        String nomeHospede,
        Long hospedeId,
        Long reservaId,
        String comentario,
        Long numQuarto,
        int avaliacao,
        LocalDateTime dataPostagem,
        LocalDateTime dataEdicao
){
    public ComentarioResponseDto(Comentario comentario) {
        this(
                comentario.getHospede().getNome(),
                comentario.getHospede().getId(),
                comentario.getReserva().getId(),
                comentario.getComentario(),
                comentario.getReserva().getQuarto().getNumero(),
                comentario.getAvaliacao().ordinal(),
                comentario.getCreatedAt(),
                comentario.getUpdatedAt()
        );
    }
}
