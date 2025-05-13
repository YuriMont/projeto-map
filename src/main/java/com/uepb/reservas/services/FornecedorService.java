package com.uepb.reservas.services;

import com.uepb.reservas.models.Fornecedor;
import com.uepb.reservas.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public Fornecedor createFornecedor(Fornecedor fncdr){
        return repository.save(fncdr);
    }

    public List<Fornecedor> findFornecedor(){
        return repository.findAll();
    }
}
