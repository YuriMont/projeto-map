package com.uepb.reservas.services;

import com.uepb.reservas.models.Quarto;
import com.uepb.reservas.repositories.QuartoReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {

    @Autowired
    private QuartoReposiroty repository;

    public Quarto createQuarto(Quarto q){
        return repository.save(q);
    }

    public List<Quarto> findQuarto(){
        return repository.findAll();
    }
}