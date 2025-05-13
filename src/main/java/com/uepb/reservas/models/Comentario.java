package com.uepb.reservas.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_hospede", nullable = false)
    private Hospede hospede;
    @ManyToOne
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reserva reserva;
    @Column(columnDefinition = "TEXT")
    private String comentario;
    private int avaliacao;
    private Date dataComentario;
}
