package com.uepb.reservas.models;

import com.uepb.reservas.enums.QuartoStatus;
import com.uepb.reservas.enums.QuartoTipo;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Quarto extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private Long numero;
    @Enumerated(EnumType.STRING)
    private QuartoTipo tipo;
    @Enumerated(EnumType.STRING)
    private QuartoStatus status;
    private Integer capacidade;
    private Double precoDiaria;
    @OneToMany(mappedBy = "quarto", cascade = CascadeType.ALL)
    private List <Reserva> reservas;
}
