package com.uepb.reservas.dtos.responses;

import com.uepb.reservas.models.Funcionario;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public record FuncionarioResponseDto(
        Long id,
        String nome,
        String cargo,
        String email,
        String telefone,
        Date dataContratacao,
        List<ManutencaoQuartoResponseDto> manutencoes
) {
    public FuncionarioResponseDto(Funcionario funcionario){
        this(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getCargo(),
                funcionario.getEmail(),
                funcionario.getTelefone(),
                funcionario.getDataContratacao(),
                Optional.ofNullable(funcionario.getManutencoes())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(item -> new ManutencaoQuartoResponseDto(item))
                        .toList()
        );
    }

}
