package com.uepb.reservas.controllers;

import com.uepb.reservas.dtos.requests.ConsumoRequestDto;
import com.uepb.reservas.dtos.responses.ConsumoResponseDto;
import com.uepb.reservas.services.ConsumoService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumo")
@Tag(name = "Consumo", description = "Endpoints relacionados aos consumos.")
public class ConsumoController {

    @Autowired
    private ConsumoService service;

    @GetMapping
    public ResponseEntity<List<ConsumoResponseDto>> findAll(){
        return ResponseEntity.status(200).body(service.findConsumos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumoResponseDto> findById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Consumo id")
            Long id)
    {
        return ResponseEntity.status(200).body(service.findConsumoById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Consumo id")
            Long id)
    {
        service.deleteConsumoByid(id);

        return ResponseEntity.status(200).body("Consumo deletado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsumoResponseDto> updateById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Consumo id")
            Long id,
            @RequestBody ConsumoRequestDto consumoRequestDto
            )
    {
        return ResponseEntity.status(200).body(service.updateConsumo(id, consumoRequestDto));
    }

    @PostMapping()
    public ResponseEntity<ConsumoResponseDto> create(@RequestBody ConsumoRequestDto consumoRequestDto){
        var response = service.createConsumo(consumoRequestDto);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}
