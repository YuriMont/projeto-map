package com.uepb.reservas.dtos.requests;

import java.time.LocalDateTime;

public record ReservaRequestDto(
    Long id_hospede,
    Long id_quarto,
    LocalDateTime dataCheckin,
    LocalDateTime dataCheckout
){}
