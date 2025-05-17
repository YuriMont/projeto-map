package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.ServicoRequestDto;
import com.uepb.reservas.models.Servico;
import com.uepb.reservas.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public Servico createServico(ServicoRequestDto servicoRequestDto){
        return repository.save(new Servico(servicoRequestDto));
    }

    public Optional<Servico> findServicoById(Long id){
        return repository.findById(id);
    }

    public Servico updateServico(Long id, ServicoRequestDto servicoRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        return repository.save(new Servico(id, servicoRequestDto));
    }

    public void deleteServicoById(Long id){
        repository.deleteById(id);
    }

    public List<Servico> findServico(){
        return repository.findAll();
    }
}
