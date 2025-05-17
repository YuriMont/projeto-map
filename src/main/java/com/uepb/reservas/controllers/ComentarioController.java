package com.uepb.reservas.controllers;

import com.uepb.reservas.dtos.requests.ComentarioRequestDto;
import com.uepb.reservas.models.Comentario;
import com.uepb.reservas.services.ComentarioService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentario")
@Tag(name = "Comentário", description = "Endpoints relacionados aos comentários e avaliações.")
public class ComentarioController {

    @Autowired
    private ComentarioService service;

    @GetMapping
    public ResponseEntity<List<Comentario>> findAll(){
        return ResponseEntity.status(200).body(service.findComentario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Comentario>> findById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Comentário id")
            Long id)
    {
        return ResponseEntity.status(200).body(service.findComentarioById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Comentário id")
            Long id)
    {
        service.deleteComentarioById(id);

        return ResponseEntity.status(200).body("Comentário deletado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> updateById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Comentário id")
            Long id,
            @RequestBody ComentarioRequestDto comentarioRequestDto
            )
    {
        return ResponseEntity.status(200).body(service.updateComentario(id, comentarioRequestDto));
    }

    @PostMapping()
    public ResponseEntity<Comentario> create(@RequestBody ComentarioRequestDto comentarioRequestDto){
        var response = service.createComentario(comentarioRequestDto);
        System.out.println(response);
        return ResponseEntity.status(200).body(response);
    }
}
