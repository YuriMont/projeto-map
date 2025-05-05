package com.uepb.reservas.controllers;

import com.uepb.reservas.models.Hospede;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospede")
@Tag(name = "Hospede", description = "Endpoints relacionados aos hóspedes")
public class HospedeController {

    @GetMapping
    @Operation(summary = "Retorna um modelo vazio de hóspede", description = "Usado como exemplo de payload ou para testes iniciais.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objeto Hospede retornado com sucesso", useReturnTypeSchema = false),
            @ApiResponse(responseCode = "400", description = "Erro ao processar a requisição", useReturnTypeSchema = false)
    })
    public ResponseEntity<Hospede> ShowHospede(){
        return ResponseEntity.status(200).body(new Hospede());
    }
}
