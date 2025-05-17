package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.PagamentoRequestDto;
import com.uepb.reservas.models.Pagamento;
import com.uepb.reservas.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    public Pagamento createPagamento(PagamentoRequestDto pagamentoRequestDto){
        return repository.save(new Pagamento(pagamentoRequestDto));
    }

    public Optional<Pagamento> findPagamentoById(Long id){
        return repository.findById(id);
    }

    public Pagamento updatPagamento(Long id, PagamentoRequestDto pagamentoRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        return repository.save(new Pagamento(id, pagamentoRequestDto));
    }

    public void deletePagamentoById(Long id){
        repository.deleteById(id);
    }

    public List<Pagamento> findPagamento(){
        return repository.findAll();
    }
}
