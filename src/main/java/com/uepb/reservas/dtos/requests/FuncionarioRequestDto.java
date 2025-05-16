package com.uepb.reservas.dtos.requests;

import com.uepb.reservas.enums.FuncionarioTurno;

import java.util.Date;

public record FuncionarioRequestDto(
        String nome,
        String cargo,
        FuncionarioTurno turno,
        String email,
        String telefone,
        Date dataContratacao
){}
