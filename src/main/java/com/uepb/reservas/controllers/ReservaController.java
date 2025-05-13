package com.uepb.reservas.controllers;

import com.uepb.reservas.models.Reserva;
import com.uepb.reservas.services.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
@Tag(name = "Reserva", description = "Endpoints relacionados às reservas")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @GetMapping
    public ResponseEntity<List<Reserva>> find(){
        return ResponseEntity.status(200).body(service.findReserva());
    }

    @PostMapping("/create")
    public ResponseEntity<Reserva> create(@RequestBody Reserva r){
        var response = service.createReserva(r);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}