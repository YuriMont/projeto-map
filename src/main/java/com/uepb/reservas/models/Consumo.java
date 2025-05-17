package com.uepb.reservas.models;

import com.uepb.reservas.dtos.requests.ConsumoRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id;
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

    public Consumo (Long id){
        this.id = id;
    }

    public Consumo (ConsumoRequestDto requestDto){
        this.reserva = new Reserva(requestDto.id_reserva());
        this.descricao = requestDto.descricao();
        this.quantidade = requestDto.quantidade();
        this.precoUnitario = requestDto.precoUnitario();
        this.dataConsumo = requestDto.dataConsumo();
    }

    public Consumo (long id, ConsumoRequestDto requestDto){
        this.id = id;
        this.reserva = new Reserva(requestDto.id_reserva());
        this.descricao = requestDto.descricao();
        this.quantidade = requestDto.quantidade();
        this.precoUnitario = requestDto.precoUnitario();
        this.dataConsumo = requestDto.dataConsumo();
    }
}
