package com.uepb.reservas.controllers;

import com.uepb.reservas.dtos.requests.ServicoRequestDto;
import com.uepb.reservas.dtos.responses.ServicoResponseDto;
import com.uepb.reservas.services.ServicoService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servico")
@Tag(name = "Serviço", description = "Endpoints relacionados aos serviços.")
public class ServicoController {

    @Autowired
    private ServicoService service;

    @GetMapping
    public ResponseEntity<List<ServicoResponseDto>> findAll(){
        return ResponseEntity.status(200).body(service.findServicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoResponseDto> findById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Serviço id")
            Long id)
    {
        return ResponseEntity.status(200).body(service.findServicoById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Serviço id")
            Long id)
    {
        service.deleteServicoById(id);

        return ResponseEntity.status(200).body("Serviço deletado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoResponseDto> updateById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Serviço id")
            Long id,
            @RequestBody ServicoRequestDto servicoRequestDto
            )
    {
        return ResponseEntity.status(200).body(service.updateServico(id, servicoRequestDto));
    }

    @PostMapping()
    public ResponseEntity<ServicoResponseDto> create(@RequestBody ServicoRequestDto servicoRequestDto){
        var response = service.createServico(servicoRequestDto);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}
