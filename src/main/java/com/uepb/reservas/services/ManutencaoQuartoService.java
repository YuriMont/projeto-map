package com.uepb.reservas.services;

import com.uepb.reservas.models.ManutencaoQuarto;
import com.uepb.reservas.repositories.ManutencaoQuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManutencaoQuartoService {

    @Autowired
    private ManutencaoQuartoRepository repository;

    public ManutencaoQuarto createManutencaoQuarto(ManutencaoQuarto m){
        return repository.save(m);
    }

    public List<ManutencaoQuarto> findManutencaoQuarto(){
        return repository.findAll();
    }
}
