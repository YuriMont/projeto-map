package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.FornecedorRequestDto;
import com.uepb.reservas.models.Fornecedor;
import com.uepb.reservas.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public Fornecedor createFornecedor(FornecedorRequestDto fornecedorRequestDto){
        return repository.save(new Fornecedor(fornecedorRequestDto));
    }

    public Optional<Fornecedor> findFornecedorById(Long id){
        return repository.findById(id);
    }

    public Fornecedor updateFornecedor(Long id, FornecedorRequestDto fornecedorRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        return repository.save(new Fornecedor(id, fornecedorRequestDto));
    }

    public void deleteFornecedorById(Long id){
        repository.deleteById(id);
    }

    public List<Fornecedor> findFornecedor(){
        return repository.findAll();
    }
}
