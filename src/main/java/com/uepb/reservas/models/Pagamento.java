package com.uepb.reservas.models;

import com.uepb.reservas.enums.FormaPagamento;

import jakarta.persistence.*;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;
    private Double valorPago;
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;
    
}
