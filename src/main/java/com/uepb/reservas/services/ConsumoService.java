package com.uepb.reservas.services;

import com.uepb.reservas.models.Consumo;
import com.uepb.reservas.repositories.ConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumoService {

    @Autowired
    private ConsumoRepository repository;

    public Consumo createConsumo(Consumo csm){
        return repository.save(csm);
    }

    public List<Consumo> findConsumo(){
        return repository.findAll();
    }
}
