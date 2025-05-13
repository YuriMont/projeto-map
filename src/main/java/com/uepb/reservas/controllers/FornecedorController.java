package com.uepb.reservas.controllers;

import com.uepb.reservas.models.Fornecedor;
import com.uepb.reservas.services.FornecedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
@Tag(name = "Fornecedor", description = "Endpoints relacionados aos fornecedores.")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> find(){
        return ResponseEntity.status(200).body(service.findFornecedor());
    }

    @PostMapping("/create")
    public ResponseEntity<Fornecedor> create(@RequestBody Fornecedor fncdr){
        var response = service.createFornecedor(fncdr);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}
