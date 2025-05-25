package com.uepb.reservas.dtos.requests;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

public record ReservaRequestDto(

    @Schema(description = "ID do Hóspede", example = "1977")
    Long id_hospede,

    @Schema(description = "ID do Quarto", example = "40010")
    Long id_quarto,

    @Schema(description = "Data de Checkin", example = "2025-05-20 11:49:34:210")
    LocalDateTime dataCheckin,

    @Schema(description = "Data de início da manutenção", example = "2025-05-26 10:13:54:131")
    LocalDateTime dataCheckout
){}
