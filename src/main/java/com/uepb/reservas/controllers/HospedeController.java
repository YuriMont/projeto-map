package com.uepb.reservas.controllers;

import com.uepb.reservas.dtos.requests.HospedeRequestDto;
import com.uepb.reservas.dtos.responses.HospedeResponseDto;
import com.uepb.reservas.models.Hospede;
import com.uepb.reservas.services.HospedeService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospede")
@Tag(name = "Hóspede", description = "Endpoints relacionados aos hóspedes")
public class HospedeController {

    @Autowired
    private HospedeService service;

    @GetMapping
    public ResponseEntity<List<HospedeResponseDto>> findAll(){
        return ResponseEntity.status(200).body(service.findHospedes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospedeResponseDto> findById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Hóspede id")
            Long id)
    {
        return ResponseEntity.status(200).body(service.findHospedeById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Hóspede id")
            Long id)
    {
        service.deleteHospedeById(id);

        return ResponseEntity.status(200).body("Hóspede deletado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<HospedeResponseDto> updateById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Hóspede id")
            Long id,
            @RequestBody HospedeRequestDto hospedeRequestDto
            )
    {
        return ResponseEntity.status(200).body(service.updateHospede(id, hospedeRequestDto));
    }

    @PostMapping()
    public ResponseEntity<HospedeResponseDto> create(@RequestBody HospedeRequestDto hospedeRequestDto){
        var response = service.createHospede(hospedeRequestDto);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}
