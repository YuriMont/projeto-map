package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.ServicoRequestDto;
import com.uepb.reservas.dtos.responses.ServicoResponseDto;
import com.uepb.reservas.models.Servico;
import com.uepb.reservas.repositories.ServicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    @Transactional
    public ServicoResponseDto createServico(ServicoRequestDto servicoRequestDto){
        var servico = repository.save(new Servico(servicoRequestDto));
        return new ServicoResponseDto(servico);
    }

    @Transactional
    public ServicoResponseDto findServicoById(Long id){
        var servico = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id não encontrado"));

        return new ServicoResponseDto(servico);
    }

    @Transactional
    public ServicoResponseDto updateServico(Long id, ServicoRequestDto servicoRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        var servico = repository.save(new Servico(id, servicoRequestDto));
        return new ServicoResponseDto(servico);
    }

    @Transactional
    public void deleteServicoById(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public List<ServicoResponseDto> findServicos(){
        List<Servico> list = repository.findAll();
        return list.stream().map(item -> new ServicoResponseDto(item)).toList();
    }
}
