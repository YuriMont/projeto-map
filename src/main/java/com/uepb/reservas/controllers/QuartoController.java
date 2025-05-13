package com.uepb.reservas.controllers;

import com.uepb.reservas.models.Quarto;
import com.uepb.reservas.services.QuartoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quarto")
@Tag(name = "Quarto", description = "Endpoints relacionados aos quartos.")
public class QuartoController {

    @Autowired
    private QuartoService service;

    @GetMapping
    public ResponseEntity<List<Quarto>> find(){
        return ResponseEntity.status(200).body(service.findQuarto());
    }

    @PostMapping("/create")
    public ResponseEntity<Quarto> create(@RequestBody Quarto q){
        var response = service.createQuarto(q);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}