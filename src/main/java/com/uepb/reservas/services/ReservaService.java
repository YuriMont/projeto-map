package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.ReservaRequestDto;
import com.uepb.reservas.models.Hospede;
import com.uepb.reservas.models.Quarto;
import com.uepb.reservas.models.Reserva;
import com.uepb.reservas.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repository;

    public Reserva createReserva(ReservaRequestDto reservaRequestDto){
        return repository.save(new Reserva(reservaRequestDto));
    }

    public Optional<Reserva> findReservaById(Long id){
        return repository.findById(id);
    }

    public Reserva updateReserva(Long id, ReservaRequestDto reservaRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        return repository.save(new Reserva(id, reservaRequestDto));
    }

    public void deleteReservaById(Long id){
        repository.deleteById(id);
    }

    public List<Reserva> findReserva(){
        return repository.findAll();
    }

    private void ocuparQuarto(Quarto quarto){
        quarto.setStatus(OCUPADO);
    }

    private boolean verificarQuantidadeHospede(Quarto quarto){
        Scanner i = new Scanner(System.in);
        
        System.out.println("Quantas pessoas?");
        int quantHosp = i.nextInt();

        if(quantHosp < 1)
            System.out.println("Melhor nem reservar.");
        
        else{
            if(quarto.getCapacidade() < quantHosp)
                System.out.println("Quantidade excedente de hospedes.");
                return false;
        }
        return true;
    }
    public void reservarQuarto(Hospede hospede, Quarto quarto){
        
        if(quarto.getStatus() == "OCUPADO")
            System.out.println("QUARTO OCUPADO.");

        else if(quarto.getStatus() == "MANUTENCAO")
            System.out.println("QUARTO EM MANUTENCAO.");

        else{
            verificarQuantidadeHospede(quarto);
            while (!verificarQuantidadeHospede(quarto)) {
                verificarQuantidadeHospede(quarto);
            }

        
            
        }

    }
}