package com.uepb.reservas.controllers;

import com.uepb.reservas.models.Hospede;
import com.uepb.reservas.services.HospedeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospede")
@Tag(name = "Hospede", description = "Endpoints relacionados aos hóspedes")
public class HospedeController {

    @Autowired
    private HospedeService service;

    @GetMapping
    public ResponseEntity<List<Hospede>> find(){
        return ResponseEntity.status(200).body(service.findHospedes());
    }

    @PostMapping("/create")
    public ResponseEntity<Hospede> create(@RequestBody Hospede h){
        var response = service.createHospede(h);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}
