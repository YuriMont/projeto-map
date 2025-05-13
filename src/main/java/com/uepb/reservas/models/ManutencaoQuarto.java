package com.uepb.reservas.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
public class ManutencaoQuarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_quarto")
    private Quarto quarto;
    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
    private String descricao;
    private Date dataInicio;
    private Date dataFim;
    private String status;
}
