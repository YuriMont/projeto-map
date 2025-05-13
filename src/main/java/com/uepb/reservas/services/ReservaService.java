package com.uepb.reservas.services;

import com.uepb.reservas.models.Reserva;
import com.uepb.reservas.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repository;

    public Reserva createReserva(Reserva r){
        return repository.save(r);
    }

    public List<Reserva> findReserva(){
        return repository.findAll();
    }
}