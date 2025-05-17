package com.uepb.reservas.models;

import com.uepb.reservas.dtos.requests.ServicoRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
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
    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;
    private String nome;
    private String descricao;
    private Double valor;

    public Servico(Long id){
        this.id = id;
    }

    public Servico (ServicoRequestDto requestDto){
        this.reserva = new Reserva(requestDto.id_reserva());
        this.nome = requestDto.nome();
        this.descricao = requestDto.descricao();
        this.valor = requestDto.valor();
    }

    public Servico (Long id, ServicoRequestDto requestDto){
        this.id = id;
        this.reserva = new Reserva(requestDto.id_reserva());
        this.nome = requestDto.nome();
        this.descricao = requestDto.descricao();
        this.valor = requestDto.valor();
    }
}
