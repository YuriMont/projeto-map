package com.uepb.reservas.dtos.requests;

import com.uepb.reservas.enums.ReservaStatus;

import java.time.LocalDateTime;
import java.util.Date;

public record ReservaRequestDto(
    Long id_hospede,
    Long id_quarto,
    LocalDateTime dataCheckin,
    LocalDateTime dataCheckout
){}
