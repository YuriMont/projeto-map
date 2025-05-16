package com.uepb.reservas.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Consumo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reserva reserva;
    private String descricao;
    private int quantidade;
    private double precoUnitario;
    private Date dataConsumo;
}
