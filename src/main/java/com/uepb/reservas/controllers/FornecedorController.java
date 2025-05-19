package com.uepb.reservas.controllers;

import com.uepb.reservas.dtos.requests.FornecedorRequestDto;
import com.uepb.reservas.models.Fornecedor;
import com.uepb.reservas.services.FornecedorService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedor")
@Tag(name = "Fornecedor", description = "Endpoints relacionados aos fornecedores.")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> findAll(){
        return ResponseEntity.status(200).body(service.findFornecedor());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Fornecedor>> findById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Fornecedor id")
            Long id)
    {
        return ResponseEntity.status(200).body(service.findFornecedorById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Fornecedor id")
            Long id)
    {
        service.deleteFornecedorById(id);

        return ResponseEntity.status(200).body("Fornecedor deletado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> updateById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Fornecedor id")
            Long id,
            @RequestBody FornecedorRequestDto fornecedorRequestDto
            )
    {
        return ResponseEntity.status(200).body(service.updateFornecedor(id, fornecedorRequestDto));
    }

    @PostMapping()
    public ResponseEntity<Fornecedor> create(@RequestBody FornecedorRequestDto fornecedorRequestDto){
        var response = service.createFornecedor(fornecedorRequestDto);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}
