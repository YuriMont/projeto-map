package com.uepb.reservas.controllers;

import com.uepb.reservas.dtos.requests.ManutencaoQuartoRequestDto;
import com.uepb.reservas.dtos.responses.ManutencaoQuartoResponseDto;
import com.uepb.reservas.services.ManutencaoQuartoService;
import io.swagger.v3.oas.annotations.Parameter;
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
    public ResponseEntity<List<ManutencaoQuartoResponseDto>> findAll(){
        return ResponseEntity.status(200).body(service.findManutencoesQuarto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManutencaoQuartoResponseDto> findById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Manutenção de Quarto id")
            Long id)
    {
        return ResponseEntity.status(200).body(service.findManutencaoQuartoById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Manutenção de Quarto id")
            Long id)
    {
        service.deleteManutencaoQuartoById(id);

        return ResponseEntity.status(200).body("Manutenção de Quarto deletado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManutencaoQuartoResponseDto> updateById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Manutenção de Quarto id")
            Long id,
            @RequestBody ManutencaoQuartoRequestDto manutencaoQuartoRequestDto
            )
    {
        return ResponseEntity.status(200).body(service.updateManutencaoQuarto(id, manutencaoQuartoRequestDto));
    }

    @PostMapping()
    public ResponseEntity<ManutencaoQuartoResponseDto> create(@RequestBody ManutencaoQuartoRequestDto manutencaoQuartoRequestDto){
        var response = service.createManutencaoQuarto(manutencaoQuartoRequestDto);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}
