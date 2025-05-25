package com.uepb.reservas.dtos.requests;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;

public record HospedeRequestDto(

    @Schema(description = "Nome do Hóspede", example = "Giorgian Daniel de Arrascaeta")
    String nome,

    @Schema(description = "CPF do Hóspede", example = "098.091.949-93")
    String cpf,

    @Schema(description = "Email do Hóspede", example = "gidaniarraca@gmail.com")
    String email,

    @Schema(description = "Telefone do Hóspede", example = "(87) 9 9001-7511")
    String telefone,

    @Schema(description = "Data de nascimento do Hóspede", example = "1995-03-03")
    Date dataNascimento
){}
