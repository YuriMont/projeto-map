package com.uepb.reservas.controllers;

import com.uepb.reservas.dtos.requests.ReservaRequestDto;
import com.uepb.reservas.dtos.responses.ReservaResponseDto;
import com.uepb.reservas.services.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
@Tag(name = "Reserva", description = "Endpoints relacionados às reservas.")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @GetMapping
    public ResponseEntity<List<ReservaResponseDto>> findAll(){
        return ResponseEntity.status(200).body(service.findReservas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDto> findById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Reserva id")
            Long id)
    {
        return ResponseEntity.status(200).body(service.findReservaById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Reserva id")
            Long id)
    {
        service.deleteReservaById(id);

        return ResponseEntity.status(200).body("Reserva deletado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaResponseDto> updateById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Reserva id")
            Long id,
            @RequestBody ReservaRequestDto reservaRequestDto
            )
    {
        return ResponseEntity.status(200).body(service.updateReserva(id, reservaRequestDto));
    }

    @PostMapping()
    @Operation(summary = "Fazer checkin")
    public ResponseEntity<ReservaResponseDto> create(@RequestBody ReservaRequestDto reservaRequestDto){
        var response = service.createReserva(reservaRequestDto);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("/{id}/adicionar-consumo/{consumoId}")
    public ResponseEntity<ReservaResponseDto> addConsumo(
            @PathVariable("id")
            @Parameter(name = "id", description = "Reserva id")
            Long id,
            @PathVariable("consumoId")
            @Parameter(name = "consumoId", description = "Cosumo id")
            Long consumoId
    )
    {
        return ResponseEntity.status(200).body(service.addConsumo(id, consumoId));
    }

    @PutMapping("/{id}/adicionar-servico/{servicoId}")
    public ResponseEntity<ReservaResponseDto> addServico(
            @PathVariable("id")
            @Parameter(name = "id", description = "Reserva id")
            Long id,
            @PathVariable("servicoId")
            @Parameter(name = "servicoId", description = "Serviço id")
            Long servicoId
    )
    {
        return ResponseEntity.status(200).body(service.addServico(id, servicoId));
    }
}
