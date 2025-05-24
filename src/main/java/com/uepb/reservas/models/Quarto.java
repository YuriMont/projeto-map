package com.uepb.reservas.models;

import com.uepb.reservas.dtos.requests.QuartoRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import lombok.*;

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
    @Enumerated(EnumType.STRING)
    private QuartoTipo tipo;
    @Enumerated(EnumType.STRING)
    private QuartoStatus status;
    private Integer capacidade;
    private Double precoDiaria;
    @OneToMany(mappedBy = "quarto", cascade = CascadeType.ALL)
    private List <Reserva> reservas;
    private List<Consumo> consumos;

    public Quarto (Long id){
        this.id = id;
    }

    public Quarto (QuartoRequestDto requestDto){
        this.numero = requestDto.numero();
        this.tipo = requestDto.tipo();
        this.status = requestDto.status();
        this.capacidade = requestDto.capacidade();
        this.precoDiaria = requestDto.precoDiaria();
    }

    public Quarto (Long id, QuartoRequestDto requestDto){
        this.id = id;
        this.numero = requestDto.numero();
        this.tipo = requestDto.tipo();
        this.status = requestDto.status();
        this.capacidade = requestDto.capacidade();
        this.precoDiaria = requestDto.precoDiaria();
    }
}
