package com.uepb.reservas.dtos.requests;

public record FornecedorRequestDto(
        Long id_consumo,
        long CNPJ,
        String nome,
        String tipoProdutoServico,
        String email,
        String telefone
){}
