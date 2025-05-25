package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.FuncionarioRequestDto;
import com.uepb.reservas.dtos.responses.FuncionarioResponseDto;
import com.uepb.reservas.models.Funcionario;
import com.uepb.reservas.repositories.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Transactional
    public FuncionarioResponseDto createFuncionario(FuncionarioRequestDto funcionarioRequestDto){
        Funcionario funcionario = repository.save(new Funcionario(funcionarioRequestDto));

        return new FuncionarioResponseDto(funcionario);
    }

    @Transactional
    public FuncionarioResponseDto findFuncionarioById(Long id){
        Funcionario funcionario = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id nao encontrado"));

        return new FuncionarioResponseDto(funcionario);
    }

    @Transactional
    public FuncionarioResponseDto updateFuncionario(Long id, FuncionarioRequestDto funcionarioRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        Funcionario funcionario = repository.save(new Funcionario(id, funcionarioRequestDto));
        return new FuncionarioResponseDto(funcionario);
    }

    @Transactional
    public void deleteFuncionarioById(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public List<FuncionarioResponseDto> findFuncionarios(){
        List<Funcionario> funcionarios = repository.findAll();

        return funcionarios.stream().map(item -> new FuncionarioResponseDto(item)).toList();
    }

}
