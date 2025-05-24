package com.uepb.reservas.dtos.requests;

import java.util.Date;

public record HospedeRequestDto(
    String nome,
    String cpf,
    String email,
    String senha,
    String telefone,
    Date dataNascimento
){}
