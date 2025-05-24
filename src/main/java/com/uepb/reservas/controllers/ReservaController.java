package com.uepb.reservas.controllers;

import com.uepb.reservas.dtos.requests.ReservaRequestDto;
import com.uepb.reservas.models.Reserva;
import com.uepb.reservas.services.ReservaService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reserva")
@Tag(name = "Reserva", description = "Endpoints relacionados às reservas.")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @GetMapping
    public ResponseEntity<List<Reserva>> findAll(){
        return ResponseEntity.status(200).body(service.findReserva());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Reserva>> findById(
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
    public ResponseEntity<Reserva> updateById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Reserva id")
            Long id,
            @RequestBody ReservaRequestDto reservaRequestDto
            )
    {
        return ResponseEntity.status(200).body(service.updateReserva(id, reservaRequestDto));
    }

    @PostMapping()
    public ResponseEntity<Reserva> create(@RequestBody ReservaRequestDto reservaRequestDto){
        var response = service.createReserva(reservaRequestDto);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping("/{id}/cancelar")
    public ResponseEntity<Reserva> cancelamentoReserva(Reserva reserva) {
        try {
            String resultado = service.cancelamentoReserva(Reserva reserva);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao cancelar reserva: " + e.getMessage());
        }
    }
}
