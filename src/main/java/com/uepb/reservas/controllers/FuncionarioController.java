package com.uepb.reservas.controllers;

import com.uepb.reservas.dtos.requests.FuncionarioRequestDto;
import com.uepb.reservas.dtos.responses.FuncionarioResponseDto;
import com.uepb.reservas.models.Funcionario;
import com.uepb.reservas.services.FuncionarioService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionario")
@Tag(name = "Funcionário", description = "Endpoints relacionados aos funcionários.")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDto>> findAll(){
        return ResponseEntity.status(200).body(service.findFuncionarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDto> findById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Funcionário id")
            Long id)
    {
        return ResponseEntity.status(200).body(service.findFuncionarioById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Funcionário id")
            Long id)
    {
        service.deleteFuncionarioById(id);

        return ResponseEntity.status(200).body("Funcionário deletado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDto> updateById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Funcionário id")
            Long id,
            @RequestBody FuncionarioRequestDto funcionarioRequestDto
            )
    {
        return ResponseEntity.status(200).body(service.updateFuncionario(id, funcionarioRequestDto));
    }

    @PostMapping()
    public ResponseEntity<FuncionarioResponseDto> create(@RequestBody FuncionarioRequestDto funcionarioRequestDto){
        var response = service.createFuncionario(funcionarioRequestDto);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}
