package com.uepb.reservas.controllers;

import com.uepb.reservas.models.Consumo;
import com.uepb.reservas.services.ConsumoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumo")
@Tag(name = "Consumo", description = "Endpoints relacionados aos consumos.")
public class ConsumoController {

    @Autowired
    private ConsumoService service;

    @GetMapping
    public ResponseEntity<List<Consumo>> find(){
        return ResponseEntity.status(200).body(service.findConsumo());
    }

    @PostMapping("/create")
    public ResponseEntity<Consumo> create(@RequestBody Consumo csm){
        var response = service.createConsumo(csm);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}