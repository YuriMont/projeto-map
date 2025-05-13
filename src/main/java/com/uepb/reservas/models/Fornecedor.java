package com.uepb.reservas.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long CNPJ;
    private String nome;
    private String tipoProdutoServico;
    private String email;
    private String telefone;
}
