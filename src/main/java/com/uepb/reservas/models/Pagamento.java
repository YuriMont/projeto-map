package com.uepb.reservas.models;

import com.uepb.reservas.enums.FormaPagamento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
