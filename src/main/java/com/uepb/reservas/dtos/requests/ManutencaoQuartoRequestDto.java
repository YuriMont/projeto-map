package com.uepb.reservas.dtos.requests;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

public record ManutencaoQuartoRequestDto(

    @Schema(description = "ID do Quarto", example = "151551")
    Long id_quarto,

    @Schema(description = "ID do Funcionário", example = "1701")
    Long id_funcionario,

    @Schema(description = "Descrição da manutenção", example = "cara simplesmente cagaram na parede eu quero me demitir")
    String descricao,

    @Schema(description = "Data de início da manutenção", example = "2025-05-26 10:14:54:201")
    LocalDateTime dataInicio,

    @Schema(description = "Data do finm da manutenção", example = "2025-05-26 16:32:31:121")
    LocalDateTime dataFim,

    @Schema(description = "Status da manutenção", example = "2")
    Integer status
){}
