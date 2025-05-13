package com.uepb.reservas.services;

import com.uepb.reservas.models.Funcionario;
import com.uepb.reservas.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario createFuncionario(Funcionario fcnr){
        return repository.save(fcnr);
    }

    public List<Funcionario> findFuncionario(){
        return repository.findAll();
    }
}
