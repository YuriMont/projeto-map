package com.uepb.reservas.controllers;

import com.uepb.reservas.models.Funcionario;
import com.uepb.reservas.services.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
@Tag(name = "Funcionário", description = "Endpoints relacionados aos funcionários.")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public ResponseEntity<List<Funcionario>> find(){
        return ResponseEntity.status(200).body(service.findFuncionario());
    }

    @PostMapping("/create")
    public ResponseEntity<Funcionario> create(@RequestBody Funcionario fcnr){
        var response = service.createFuncionario(fcnr);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}