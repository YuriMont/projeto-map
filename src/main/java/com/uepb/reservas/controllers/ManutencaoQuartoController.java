package com.uepb.reservas.controllers;

import com.uepb.reservas.dtos.requests.ManutencaoQuartoRequestDto;
import com.uepb.reservas.models.ManutencaoQuarto;
import com.uepb.reservas.services.ManutencaoQuartoService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manutencaoQuarto")
@Tag(name = "Manutenção de Quarto", description = "Endpoints relacionados às manutenções de quartos.")
public class ManutencaoQuartoController {

    @Autowired
    private ManutencaoQuartoService service;

    @GetMapping
    public ResponseEntity<List<ManutencaoQuarto>> findAll(){
        return ResponseEntity.status(200).body(service.findManutencaoQuarto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ManutencaoQuarto>> findById(
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
    public ResponseEntity<ManutencaoQuarto> updateById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Manutenção de Quarto id")
            Long id,
            @RequestBody ManutencaoQuartoRequestDto manutencaoQuartoRequestDto
            )
    {
        return ResponseEntity.status(200).body(service.updateManutencaoQuarto(id, manutencaoQuartoRequestDto));
    }

    @PostMapping()
    public ResponseEntity<ManutencaoQuarto> create(@RequestBody ManutencaoQuartoRequestDto manutencaoQuartoRequestDto){
        var response = service.createManutencaoQuarto(manutencaoQuartoRequestDto);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}
