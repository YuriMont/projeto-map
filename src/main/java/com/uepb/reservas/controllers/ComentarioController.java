package com.uepb.reservas.controllers;

import com.uepb.reservas.models.Comentario;
import com.uepb.reservas.services.ComentarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")
@Tag(name = "Comentário", description = "Endpoints relacionados aos comentários e avaliações.")
public class ComentarioController {

    @Autowired
    private ComentarioService service;

    @GetMapping
    public ResponseEntity<List<Comentario>> find(){
        return ResponseEntity.status(200).body(service.findComentario());
    }

    @PostMapping("/create")
    public ResponseEntity<Comentario> create(@RequestBody Comentario cmt){
        var response = service.createComentario(cmt);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}
