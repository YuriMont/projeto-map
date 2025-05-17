package com.uepb.reservas.models;

import com.uepb.reservas.dtos.requests.FornecedorRequestDto;
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
public class Fornecedor extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_consumo", nullable = false)
    private Consumo consumo;
    private Long CNPJ;
    private String nome;
    private String tipoProdutoServico;
    private String email;
    private String telefone;

    public Fornecedor(FornecedorRequestDto requestDto){
        this.consumo = new Consumo(requestDto.id_consumo());
        this.CNPJ = requestDto.CNPJ();
        this.nome = requestDto.nome();
        this.tipoProdutoServico = requestDto.tipoProdutoServico();
        this.email = requestDto.email();
        this.telefone = requestDto.telefone();
    }

    public Fornecedor(Long id, FornecedorRequestDto requestDto){
        this.id = id;
        this.consumo = new Consumo(requestDto.id_consumo());
        this.CNPJ = requestDto.CNPJ();
        this.nome = requestDto.nome();
        this.tipoProdutoServico = requestDto.tipoProdutoServico();
        this.email = requestDto.email();
        this.telefone = requestDto.telefone();
    }
}
