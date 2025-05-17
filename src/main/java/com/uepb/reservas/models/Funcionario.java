package com.uepb.reservas.models;

import com.uepb.reservas.dtos.requests.FuncionarioRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

import com.uepb.reservas.enums.FuncionarioTurno;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Funcionario extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cargo;
    @Enumerated(EnumType.STRING)
    private FuncionarioTurno turno;
    private String email;
    private String telefone;
    private Date dataContratacao;

    public Funcionario (Long id){
        this.id = id;
    }
    
    public Funcionario (FuncionarioRequestDto requestDto){
        this.nome = requestDto.nome();
        this.cargo = requestDto.cargo();
        this.dataContratacao = requestDto.dataContratacao();
        this.telefone = requestDto.telefone();
        this.turno = requestDto.turno();
        this.email = requestDto.email();
        this.telefone = requestDto.telefone();
    }

    public Funcionario (Long id, FuncionarioRequestDto requestDto){
        this.id = id;
        this.nome = requestDto.nome();
        this.cargo = requestDto.cargo();
        this.dataContratacao = requestDto.dataContratacao();
        this.telefone = requestDto.telefone();
        this.turno = requestDto.turno();
        this.email = requestDto.email();
        this.telefone = requestDto.telefone();
    }
}
