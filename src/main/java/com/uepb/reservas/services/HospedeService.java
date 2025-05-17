package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.HospedeRequestDto;
import com.uepb.reservas.models.Hospede;
import com.uepb.reservas.repositories.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository repository;

    public Hospede createHospede(HospedeRequestDto hospedeRequestDto){
        return repository.save(new Hospede(hospedeRequestDto));
    }

    public Optional<Hospede> findHospedeById(Long id){
        return repository.findById(id);
    }

    public Hospede updateHospede(Long id, HospedeRequestDto hospedeRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        return repository.save(new Hospede(id, hospedeRequestDto));
    }

    public void deleteHospedeById(Long id){
        repository.deleteById(id);
    }

    public List<Hospede> findHospedes(){
        return repository.findAll();
    }
}
