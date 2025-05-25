package com.uepb.reservas.dtos.responses;

import com.uepb.reservas.models.Hospede;

import java.util.Date;
import java.util.List;

public record HospedeResponseDto(
        Long id,
        String nome,
        String cpf,
        String email,
        String telefone,
        Date dataNascimento,
        List<ReservaResponseDto> reservas
) {
    public HospedeResponseDto(Hospede hospede){
        this(
                hospede.getId(),
                hospede.getNome(),
                hospede.getCpf(),
                hospede.getEmail(),
                hospede.getTelefone(),
                hospede.getDataNascimento(),
                hospede.getReservas().stream().map(item -> new ReservaResponseDto(item)).toList()
        );
    }
}
