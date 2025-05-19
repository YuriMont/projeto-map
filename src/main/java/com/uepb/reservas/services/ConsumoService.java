package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.ConsumoRequestDto;
import com.uepb.reservas.models.Consumo;
import com.uepb.reservas.repositories.ConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumoService {

    @Autowired
    private ConsumoRepository repository;

    public Consumo createConsumo(ConsumoRequestDto consumoRequestDto){
        return repository.save(new Consumo(consumoRequestDto));
    }

    public Optional<Consumo> findConsumoById(Long id){
        return repository.findById(id);
    }

    public Consumo updateConsumo(Long id, ConsumoRequestDto consumoRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        return repository.save(new Consumo(id, consumoRequestDto));
    }

    public void deleteConsumoByid(Long id){
        repository.deleteById(id);
    }

    public List<Consumo> findConsumo(){
        return repository.findAll();
    }
}
