package com.uepb.reservas.services;

import com.uepb.reservas.models.Hospede;
import com.uepb.reservas.repositories.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository repository;

    public Hospede createHospede(Hospede h){
        return repository.save(h);
    }

    public List<Hospede> findHospedes(){
        return repository.findAll();
    }


}
