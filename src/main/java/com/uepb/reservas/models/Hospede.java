package com.uepb.reservas.models;

import com.uepb.reservas.dtos.requests.HospedeRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hospede extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String cpf;
    private String email;
    private String telefone;
    private Date dataNascimento;
    @OneToMany(mappedBy = "hospede", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    public Hospede (Long id){
        this.id = id;
    }
    
    public Hospede (HospedeRequestDto requestDto){
        this.nome = requestDto.nome();
        this.cpf = requestDto.cpf();
        this.email = requestDto.email();
        this.telefone = requestDto.telefone();
        this.dataNascimento = requestDto.dataNascimento();
    }

    public Hospede (Long id, HospedeRequestDto requestDto){
        this.id = id;
        this.nome = requestDto.nome();
        this.cpf = requestDto.cpf();
        this.email = requestDto.email();
        this.telefone = requestDto.telefone();
        this.dataNascimento = requestDto.dataNascimento();
    }
}
