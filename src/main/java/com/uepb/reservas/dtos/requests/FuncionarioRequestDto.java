package com.uepb.reservas.dtos.requests;

import java.util.Date;

public record FuncionarioRequestDto(
        String nome,
        String cargo,
        String email,
        String telefone,
        Date dataContratacao
){}
