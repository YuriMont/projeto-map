package com.uepb.reservas.controllers;

import com.uepb.reservas.models.Funcionario;
import com.uepb.reservas.models.ManutencaoQuarto;
import com.uepb.reservas.services.ManutencaoQuartoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manutencaoQuarto")
@Tag(name = "Manutenção de Quarto", description = "Endpoints relacionados às manutenções de quartos.")
public class ManutencaoQuartoController {

    @Autowired
    private ManutencaoQuartoService service;

    @GetMapping
    public ResponseEntity<List<ManutencaoQuarto>> find(){
        return ResponseEntity.status(200).body(service.findManutencaoQuarto());
    }

    @PostMapping("/create")
    public ResponseEntity<ManutencaoQuarto> create(@RequestBody ManutencaoQuarto m){
        var response = service.createManutencaoQuarto(m);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}
