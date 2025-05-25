package com.uepb.reservas.models;

import com.uepb.reservas.dtos.requests.FuncionarioRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

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
    private String email;
    private String telefone;
    private Date dataContratacao;
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ManutencaoQuarto> manutencoes;

    public Funcionario (Long id){
        this.id = id;
    }
    
    public Funcionario (FuncionarioRequestDto requestDto){
        this.nome = requestDto.nome();
        this.cargo = requestDto.cargo();
        this.dataContratacao = requestDto.dataContratacao();
        this.telefone = requestDto.telefone();
        this.email = requestDto.email();
        this.telefone = requestDto.telefone();
    }

    public Funcionario (Long id, FuncionarioRequestDto requestDto){
        this.id = id;
        this.nome = requestDto.nome();
        this.cargo = requestDto.cargo();
        this.dataContratacao = requestDto.dataContratacao();
        this.telefone = requestDto.telefone();
        this.email = requestDto.email();
        this.telefone = requestDto.telefone();
    }
}
