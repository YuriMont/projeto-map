package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.QuartoRequestDto;
import com.uepb.reservas.dtos.responses.QuartoResponseDto;
import com.uepb.reservas.models.Quarto;
import com.uepb.reservas.repositories.QuartoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository repository;

    @Transactional
    public QuartoResponseDto createQuarto(QuartoRequestDto quartoRequestDto){
        Quarto quarto = repository.save(new Quarto(quartoRequestDto));

        return new QuartoResponseDto(quarto);
    }

    @Transactional
    public QuartoResponseDto findQuartoById(Long id){
        Quarto quarto = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id inválido"));

        return new QuartoResponseDto(quarto);
    }

    @Transactional
    public QuartoResponseDto updateQuarto(Long id, QuartoRequestDto quartoRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        Quarto quarto = repository.save(new Quarto(id, quartoRequestDto));
        return new QuartoResponseDto(quarto);
    }

    @Transactional
    public void deleteQuartoById(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public List<QuartoResponseDto> findQuarto(){
        List<Quarto> quartos = repository.findAll();

        return quartos.stream().map(item -> new QuartoResponseDto(item)).toList();
    }
}
