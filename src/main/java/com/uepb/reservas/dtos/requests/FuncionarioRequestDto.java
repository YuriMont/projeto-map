package com.uepb.reservas.dtos.requests;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;

public record FuncionarioRequestDto(

        @Schema(description = "Nome do funcionario", example = "Agustin Rossi")
        String nome,

        @Schema(description = "Cargo do funcionario", example = "Supervisor de Arrumacao de Quartos")
        String cargo,

        @Schema(description = "Email do funcionario", example = "tintintinrossi@gmail.com.ar")
        String email,

        @Schema(description = "Telefone do funcionario", example = "(83) 9 9340-2021")
        String telefone,

        @Schema(description = "Data de contratacao do funcionario", example = "2008-09-20")
        Date dataContratacao
){}
