package com.uepb.reservas.dtos.requests;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;

public record FuncionarioRequestDto(

        @Schema(description = "Nome do funcionário", example = "Agustin Rossi")
        String nome,

        @Schema(description = "Cargo do funcionário", example = "Supervisor de Arrumação de Quartos")
        String cargo,

        @Schema(description = "Email do funcionário", example = "tintintinrossi@gmail.com")
        String email,

        @Schema(description = "Telefone do funcionário", example = "(83) 9 9340-2021")
        String telefone,

        @Schema(description = "Data de contratação do funcionário", example = "2008-09-20")
        Date dataContratacao
){}
