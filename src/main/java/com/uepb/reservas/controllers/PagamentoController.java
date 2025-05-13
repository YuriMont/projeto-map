package com.uepb.reservas.controllers;

import com.uepb.reservas.models.Pagamento;
import com.uepb.reservas.services.PagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
@Tag(name = "Pagamento", description = "Endpoints relacionados aos pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @GetMapping
    public ResponseEntity<List<Pagamento>> find(){
        return ResponseEntity.status(200).body(service.findPagamento());
    }

    @PostMapping("/create")
    public ResponseEntity<Pagamento> create(@RequestBody Pagamento p){
        var response = service.createPagamento(p);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}