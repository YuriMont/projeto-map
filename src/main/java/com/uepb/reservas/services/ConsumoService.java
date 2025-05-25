package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.ConsumoRequestDto;
import com.uepb.reservas.dtos.responses.ConsumoResponseDto;
import com.uepb.reservas.models.Consumo;
import com.uepb.reservas.repositories.ConsumoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumoService {

    @Autowired
    private ConsumoRepository repository;

    @Transactional
    public ConsumoResponseDto createConsumo(ConsumoRequestDto consumoRequestDto){
        Consumo consumo = repository.save(new Consumo(consumoRequestDto));

        return new ConsumoResponseDto(consumo);
    }

    @Transactional
    public ConsumoResponseDto findConsumoById(Long id){
        Optional<Consumo> consumo = repository.findById(id);

        if(consumo.isEmpty()){
            return null;
        }

        return new ConsumoResponseDto(consumo.get());
    }

    @Transactional
    public ConsumoResponseDto updateConsumo(Long id, ConsumoRequestDto consumoRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        Consumo consumo = repository.save(new Consumo(id, consumoRequestDto));
        return new ConsumoResponseDto(consumo);
    }

    @Transactional
    public void deleteConsumoByid(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public List<ConsumoResponseDto> findConsumos(){
        List<Consumo> consumos = repository.findAll();

        return consumos.stream().map(item -> new ConsumoResponseDto(item)).toList();
    }
}
