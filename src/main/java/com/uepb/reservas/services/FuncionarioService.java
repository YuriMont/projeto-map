package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.FuncionarioRequestDto;
import com.uepb.reservas.models.Funcionario;
import com.uepb.reservas.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario createFuncionario(FuncionarioRequestDto funcionarioRequestDto){
        return repository.save(new Funcionario(funcionarioRequestDto));
    }

    public Optional<Funcionario> findFuncionarioById(Long id){
        return repository.findById(id);
    }

    public Funcionario updateFuncionario(Long id, FuncionarioRequestDto funcionarioRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        return repository.save(new Funcionario(id, funcionarioRequestDto));
    }

    public void deleteFuncionarioById(Long id){
        repository.deleteById(id);
    }

    public List<Funcionario> findFuncionario(){
        return repository.findAll();
    }
}
