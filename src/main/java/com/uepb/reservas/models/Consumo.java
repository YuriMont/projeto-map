package com.uepb.reservas.models;

import com.uepb.reservas.dtos.requests.ConsumoRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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
    private String descricao;
    private int quantidade;
    private double precoUnitario;

    public Consumo (Long id){
        this.id = id;
    }

    public Consumo (ConsumoRequestDto requestDto){
        this.descricao = requestDto.descricao();
        this.quantidade = requestDto.quantidade();
        this.precoUnitario = requestDto.precoUnitario();
    }

    public Consumo (long id, ConsumoRequestDto requestDto){
        this.id = id;
        this.descricao = requestDto.descricao();
        this.quantidade = requestDto.quantidade();
        this.precoUnitario = requestDto.precoUnitario();
    }
}
