package com.uepb.reservas.controllers;

import com.uepb.reservas.dtos.requests.QuartoRequestDto;
import com.uepb.reservas.models.Quarto;
import com.uepb.reservas.services.QuartoService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quarto")
@Tag(name = "Quarto", description = "Endpoints relacionados aos quartos.")
public class QuartoController {

    @Autowired
    private QuartoService service;

    @GetMapping
    public ResponseEntity<List<Quarto>> findAll(){
        return ResponseEntity.status(200).body(service.findQuarto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Quarto>> findById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Quarto id")
            Long id)
    {
        return ResponseEntity.status(200).body(service.findQuartoById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Quarto id")
            Long id)
    {
        service.deleteQuartoById(id);

        return ResponseEntity.status(200).body("Quarto deletado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quarto> updateById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Quarto id")
            Long id,
            @RequestBody QuartoRequestDto quartoRequestDto
            )
    {
        return ResponseEntity.status(200).body(service.updateQuarto(id, quartoRequestDto));
    }

    @PostMapping()
    public ResponseEntity<Quarto> create(@RequestBody QuartoRequestDto quartoRequestDto){
        var response = service.createQuarto(quartoRequestDto);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}
