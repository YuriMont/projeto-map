package com.uepb.reservas.dtos.requests;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;

public record HospedeRequestDto(

    @Schema(description = "Nome do Hospede", example = "Giorgian Daniel de Arrascaeta")
    String nome,

    @Schema(description = "CPF do Hospede", example = "098.091.949.93")
    String cpf,

    @Schema(description = "Email do Hospede", example = "gidaniarraca@gmail.com.ur")
    String email,

    @Schema(description = "Telefone do Hospede", example = "(87) 9 9001-7511")
    String telefone,

    @Schema(description = "Data de nascimento do Hospede", example = "03/03/1995")
    Date dataNascimento
){}
