package com.uepb.reservas.models;

import com.uepb.reservas.dtos.requests.ServicoRequestDto;
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
public class Servico extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double valor;

    public Servico(Long id){
        this.id = id;
    }

    public Servico (ServicoRequestDto requestDto){
        this.nome = requestDto.nome();
        this.descricao = requestDto.descricao();
        this.valor = requestDto.valor();
    }

    public Servico (Long id, ServicoRequestDto requestDto){
        this.id = id;
        this.nome = requestDto.nome();
        this.descricao = requestDto.descricao();
        this.valor = requestDto.valor();
    }
}
