package com.uepb.reservas.services;

import com.uepb.reservas.models.Servico;
import com.uepb.reservas.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public Servico createServico(Servico s){
        return repository.save(s);
    }

    public List<Servico> findServico(){
        return repository.findAll();
    }
}