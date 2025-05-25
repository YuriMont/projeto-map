package com.uepb.reservas.models;

import com.uepb.reservas.dtos.requests.QuartoRequestDto;
import jakarta.persistence.*;
import lombok.*;

import com.uepb.reservas.enums.Avaliacao;
import com.uepb.reservas.enums.QuartoStatus;
import com.uepb.reservas.enums.QuartoTipo;

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
    @Enumerated(EnumType.ORDINAL)
    private QuartoTipo tipo;
    @Enumerated(EnumType.ORDINAL)
    private QuartoStatus status;
    private Integer capacidade;
    private Double precoDiaria;
    @OneToMany(mappedBy = "quarto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List <Reserva> reservas;

    public Quarto (Long id){
        this.id = id;
    }

    public Quarto (QuartoRequestDto requestDto){
        this.numero = requestDto.numero();
        this.tipo = QuartoTipo.values()[requestDto.quartoTipo()];
        this.status = QuartoStatus.values()[requestDto.quartoStatus()];
        this.capacidade = requestDto.capacidade();
        this.precoDiaria = requestDto.precoDiaria();
    }

    public Quarto (Long id, QuartoRequestDto requestDto){
        this.id = id;
        this.numero = requestDto.numero();
        this.tipo = QuartoTipo.values()[requestDto.quartoTipo()];
        this.status = QuartoStatus.values()[requestDto.quartoStatus()];
        this.capacidade = requestDto.capacidade();
        this.precoDiaria = requestDto.precoDiaria();
    }
}
