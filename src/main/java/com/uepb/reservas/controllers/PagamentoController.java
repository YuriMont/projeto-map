package com.uepb.reservas.controllers;

import com.uepb.reservas.dtos.requests.PagamentoRequestDto;
import com.uepb.reservas.dtos.responses.PagamentoResponseDto;
import com.uepb.reservas.services.PagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
@Tag(name = "Pagamento", description = "Endpoints relacionados aos pagamentos.")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @GetMapping
    public ResponseEntity<List<PagamentoResponseDto>> findAll(){
        return ResponseEntity.status(200).body(service.findPagamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponseDto> findById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Pagamento id")
            Long id)
    {
        return ResponseEntity.status(200).body(service.findPagamentoById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Pagamento id")
            Long id)
    {
        service.deletePagamentoById(id);

        return ResponseEntity.status(200).body("Pagamento deletado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagamentoResponseDto> updateById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Pagamento id")
            Long id,
            @RequestBody PagamentoRequestDto pagamentoRequestDto
            )
    {
        return ResponseEntity.status(200).body(service.updatePagamentoMetodo(id, pagamentoRequestDto));
    }

    @PostMapping()
    @Operation(summary = "Fazer checkout")
    public ResponseEntity<PagamentoResponseDto> create(@RequestBody PagamentoRequestDto pagamentoRequestDto){
        var response = service.createPagamento(pagamentoRequestDto);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}
