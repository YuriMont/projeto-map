package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.ManutencaoQuartoRequestDto;
import com.uepb.reservas.dtos.responses.ManutencaoQuartoResponseDto;
import com.uepb.reservas.enums.QuartoStatus;
import com.uepb.reservas.models.ManutencaoQuarto;
import com.uepb.reservas.models.Quarto;
import com.uepb.reservas.repositories.FuncionarioRepository;
import com.uepb.reservas.repositories.ManutencaoQuartoRepository;
import com.uepb.reservas.repositories.QuartoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManutencaoQuartoService {

    @Autowired
    private ManutencaoQuartoRepository repository;

    @Autowired
    private QuartoRepository quartoReposiroty;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Transactional
    public ManutencaoQuartoResponseDto createManutencaoQuarto(ManutencaoQuartoRequestDto manutencaoQuartoRequestDto){
        Quarto quarto = quartoReposiroty.findById(manutencaoQuartoRequestDto.id_quarto()).orElseThrow(() -> new IllegalArgumentException("Quarto não encontrado"));

        if(!funcionarioRepository.existsById(manutencaoQuartoRequestDto.id_funcionario())){
            throw new IllegalArgumentException("Funcionario não encontrado");
        }

        quarto.setStatus(QuartoStatus.MANUTENCAO);

        quartoReposiroty.save(quarto);

        ManutencaoQuarto manutencaoQuarto = repository.save(new ManutencaoQuarto(manutencaoQuartoRequestDto));

        return new ManutencaoQuartoResponseDto(manutencaoQuarto);
    }

    @Transactional
    public ManutencaoQuartoResponseDto findManutencaoQuartoById(Long id){
        ManutencaoQuarto manutencaoQuarto = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id não encontrado"));

        return new ManutencaoQuartoResponseDto(manutencaoQuarto);
    }

    public ManutencaoQuartoResponseDto updateManutencaoQuarto(Long id, ManutencaoQuartoRequestDto manutencaoQuartoRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        Quarto quarto = quartoReposiroty.findById(manutencaoQuartoRequestDto.id_quarto()).orElseThrow(() -> new IllegalArgumentException("Quarto não encontrado"));

        if(manutencaoQuartoRequestDto.status() != 1){
            quarto.setStatus(QuartoStatus.DISPONIVEL);
        }else{
            quarto.setStatus(QuartoStatus.MANUTENCAO);
        }

        quartoReposiroty.save(quarto);

        ManutencaoQuarto manutencaoQuarto = repository.save(new ManutencaoQuarto(id, manutencaoQuartoRequestDto));

        return new ManutencaoQuartoResponseDto(manutencaoQuarto);
    }

    @Transactional
    public void deleteManutencaoQuartoById(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public List<ManutencaoQuartoResponseDto> findManutencoesQuarto(){
        List<ManutencaoQuarto> list = repository.findAll();

        return list.stream().map(item -> new ManutencaoQuartoResponseDto(item)).toList();
    }
}
