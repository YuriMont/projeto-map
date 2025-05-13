package com.uepb.reservas.controllers;

import com.uepb.reservas.models.Servico;
import com.uepb.reservas.services.ServicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servico")
@Tag(name = "Serviço", description = "Endpoints relacionados aos serviços.")
public class ServicoController {

    @Autowired
    private ServicoService service;

    @GetMapping
    public ResponseEntity<List<Servico>> find(){
        return ResponseEntity.status(200).body(service.findServico());
    }

    @PostMapping("/create")
    public ResponseEntity<Servico> create(@RequestBody Servico s){
        var response = service.createServico(s);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}