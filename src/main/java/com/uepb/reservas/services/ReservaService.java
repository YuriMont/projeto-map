package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.ReservaRequestDto;
import com.uepb.reservas.models.Reserva;
import com.uepb.reservas.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}