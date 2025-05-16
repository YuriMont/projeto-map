package com.uepb.reservas.models;

import com.uepb.reservas.enums.FormaPagamento;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pagamento extends BaseEntity{
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
