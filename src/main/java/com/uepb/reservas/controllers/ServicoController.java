package com.uepb.reservas.controllers;

import com.uepb.reservas.dtos.requests.ServicoRequestDto;
import com.uepb.reservas.models.Servico;
import com.uepb.reservas.services.ServicoService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servico")
@Tag(name = "Serviço", description = "Endpoints relacionados aos serviços.")
public class ServicoController {

    @Autowired
    private ServicoService service;

    @GetMapping
    public ResponseEntity<List<Servico>> findAll(){
        return ResponseEntity.status(200).body(service.findServico());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Servico>> findById(
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
    public ResponseEntity<Servico> updateById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Serviço id")
            Long id,
            @RequestBody ServicoRequestDto servicoRequestDto
            )
    {
        return ResponseEntity.status(200).body(service.updateServico(id, servicoRequestDto));
    }

    @PostMapping()
    public ResponseEntity<Servico> create(@RequestBody ServicoRequestDto servicoRequestDto){
        var response = service.createServico(servicoRequestDto);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}
