package com.uepb.reservas.dtos.requests;

import com.uepb.reservas.enums.ReservaStatus;

import java.util.Date;

public record ReservaRequestDto(
    Long id_hospede,
    Long id_quarto,
    Date dataCheckin,
    Date dataCheckout,
    ReservaStatus status
){}
