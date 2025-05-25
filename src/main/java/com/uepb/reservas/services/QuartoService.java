package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.QuartoRequestDto;
import com.uepb.reservas.models.Consumo;
import com.uepb.reservas.models.Quarto;
import com.uepb.reservas.repositories.QuartoReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuartoService {

    @Autowired
    private QuartoReposiroty repository;

    public Quarto createQuarto(QuartoRequestDto quartoRequestDto){
        return repository.save(new Quarto(quartoRequestDto));
    }

    public Optional<Quarto> findQuartoById(Long id){
        return repository.findById(id);
    }

    public Quarto updateQuarto(Long id, QuartoRequestDto quartoRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        return repository.save(new Quarto(id, quartoRequestDto));
    }

    public void deleteQuartoById(Long id){
        repository.deleteById(id);
    }

    public List<Quarto> findQuarto(){
        return repository.findAll();
    }

    public static void listarConsumos(List<Consumo> consumos) {
        if (consumos == null || consumos.isEmpty()) {
            System.out.println("Nenhum consumo registrado.");
            return;
        }

        for (Consumo consumo : consumos) {
            System.out.println(consumo);
        }
    }
}
