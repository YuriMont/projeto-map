package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.ManutencaoQuartoRequestDto;
import com.uepb.reservas.models.ManutencaoQuarto;
import com.uepb.reservas.repositories.ManutencaoQuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManutencaoQuartoService {

    @Autowired
    private ManutencaoQuartoRepository repository;

    public ManutencaoQuarto createManutencaoQuarto(ManutencaoQuartoRequestDto manutencaoQuartoRequestDto){
        return repository.save(new ManutencaoQuarto(manutencaoQuartoRequestDto));
    }

    public Optional<ManutencaoQuarto> findManutencaoQuartoById(Long id){
        return repository.findById(id);
    }

    public ManutencaoQuarto updateManutencaoQuarto(Long id, ManutencaoQuartoRequestDto manutencaoQuartoRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        return repository.save(new ManutencaoQuarto(id, manutencaoQuartoRequestDto));
    }

    public void deleteManutencaoQuartoById(Long id){
        repository.deleteById(id);
    }

    public List<ManutencaoQuarto> findManutencaoQuarto(){
        return repository.findAll();
    }
}
