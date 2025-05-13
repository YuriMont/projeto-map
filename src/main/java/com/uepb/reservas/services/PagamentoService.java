package com.uepb.reservas.services;

import com.uepb.reservas.models.Pagamento;
import com.uepb.reservas.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    public Pagamento createPagamento(Pagamento p){
        return repository.save(p);
    }

    public List<Pagamento> findPagamento(){
        return repository.findAll();
    }
}