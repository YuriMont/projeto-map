package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.HospedeRequestDto;
import com.uepb.reservas.dtos.responses.HospedeResponseDto;
import com.uepb.reservas.models.Hospede;
import com.uepb.reservas.repositories.HospedeRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository repository;

    @Transactional
    public HospedeResponseDto createHospede(HospedeRequestDto hospedeRequestDto){
        Hospede hospede = repository.save(new Hospede(hospedeRequestDto));

        return new HospedeResponseDto(hospede);
    }

    @Transactional
    public HospedeResponseDto findHospedeById(Long id){
        Hospede hospede = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id inválido"));

        return new HospedeResponseDto(hospede);
    }

    @Transactional
    public HospedeResponseDto updateHospede(Long id, HospedeRequestDto hospedeRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        Hospede hospede = repository.save(new Hospede(id, hospedeRequestDto));

        return new HospedeResponseDto(hospede);
    }

    @Transactional
    public void deleteHospedeById(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public List<HospedeResponseDto> findHospedes(){
        List<Hospede> hospedes = repository.findAll();

        return hospedes.stream().map((item -> new HospedeResponseDto(item))).toList();
    }

}
