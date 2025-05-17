package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.ComentarioRequestDto;
import com.uepb.reservas.models.Comentario;
import com.uepb.reservas.repositories.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository repository;

    public Comentario createComentario(ComentarioRequestDto comentarioRequestDto){
        return repository.save(new Comentario(comentarioRequestDto));
    }

    public Optional<Comentario> findComentarioById(Long id){
        return repository.findById(id);
    }

    public Comentario updateComentario(Long id, ComentarioRequestDto comentarioRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        return repository.save(new Comentario(id, comentarioRequestDto));
    }

    public void deleteComentarioById(Long id){
        repository.deleteById(id);
    }

    public List<Comentario> findComentario(){
        return repository.findAll();
    }
}
