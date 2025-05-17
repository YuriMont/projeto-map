package com.uepb.reservas.models;

import com.uepb.reservas.dtos.requests.ManutencaoQuartoRequestDto;
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
public class ManutencaoQuarto extends BaseEntity{
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

    public ManutencaoQuarto(ManutencaoQuartoRequestDto requestDto){
        this.quarto = new Quarto(requestDto.id_quarto());
        this.funcionario = new Funcionario(requestDto.id_funcionario());
        this.descricao = requestDto.descricao();
        this.dataInicio = requestDto.dataInicio();
        this.dataFim =  requestDto.dataFim();
        this.status = requestDto.status();
    }

    public ManutencaoQuarto(Long id, ManutencaoQuartoRequestDto requestDto){
        this.id = id;
        this.quarto = new Quarto(requestDto.id_quarto());
        this.funcionario = new Funcionario(requestDto.id_funcionario());
        this.descricao = requestDto.descricao();
        this.dataInicio = requestDto.dataInicio();
        this.dataFim =  requestDto.dataFim();
        this.status = requestDto.status();
    }

}
