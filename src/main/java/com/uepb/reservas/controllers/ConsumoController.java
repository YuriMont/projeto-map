package com.uepb.reservas.controllers;

import com.uepb.reservas.dtos.requests.ConsumoRequestDto;
import com.uepb.reservas.models.Consumo;
import com.uepb.reservas.services.ConsumoService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consumo")
@Tag(name = "Consumo", description = "Endpoints relacionados aos consumos.")
public class ConsumoController {

    @Autowired
    private ConsumoService service;

    @GetMapping
    public ResponseEntity<List<Consumo>> findAll(){
        return ResponseEntity.status(200).body(service.findConsumo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Consumo>> findById(
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
    public ResponseEntity<Consumo> updateById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Consumo id")
            Long id,
            @RequestBody ConsumoRequestDto consumoRequestDto
            )
    {
        return ResponseEntity.status(200).body(service.updateConsumo(id, consumoRequestDto));
    }

    @PostMapping()
    public ResponseEntity<Consumo> create(@RequestBody ConsumoRequestDto consumoRequestDto){
        var response = service.createConsumo(consumoRequestDto);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}
