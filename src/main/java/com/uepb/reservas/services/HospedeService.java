package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.HospedeRequestDto;
import com.uepb.reservas.models.Hospede;
import com.uepb.reservas.repositories.HospedeRepository;

import jakarta.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class HospedeService {
    private final List<Hospede> hospedes;

    public HospedeService(List<Hospede> hospedes) {
        this.hospedes = hospedes;
    }

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

    public boolean fazerCadastro(HospedeRequestDto request) throws ParseException {

        Hospede hospede = new Hospede(
                null, request.nome(),
                request.cpf(),
                request.email(),
                request.telefone(),
                request.senha(),
                request.dataNascimento(), null
        );

        hospedes.add(hospede);
        return true;
    }

    public boolean fazerLogin(String email, String senha) {
        return hospedes.stream()
                .anyMatch(h -> h.getEmail().equals(email) && h.getSenha().equals(senha));
    }

    public void verificarIdade(Hospede hospede){
        
    }
}
