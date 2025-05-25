package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.ComentarioRequestDto;
import com.uepb.reservas.dtos.responses.ComentarioResponseDto;
import com.uepb.reservas.models.Comentario;
import com.uepb.reservas.repositories.ComentarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository repository;

    @Transactional
    public ComentarioResponseDto createComentario(ComentarioRequestDto comentarioRequestDto){
        Comentario comentario = repository.save(new Comentario(comentarioRequestDto));

        return new ComentarioResponseDto(comentario);
    }

    @Transactional
    public ComentarioResponseDto findComentarioById(Long id){
        Optional<Comentario> comentario = repository.findById(id);

        if(comentario.isEmpty()){
            return null;
        }

        return new ComentarioResponseDto(comentario.get());
    }

    public ComentarioResponseDto updateComentario(Long id, ComentarioRequestDto comentarioRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        Comentario comentario = repository.save(new Comentario(id, comentarioRequestDto));

        return new ComentarioResponseDto(comentario);
    }

    @Transactional
    public void deleteComentarioById(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public List<ComentarioResponseDto> findComentarios(){
        List<Comentario> result = repository.findAll();

        return result.stream().map(item -> new ComentarioResponseDto(item)).toList();
    }
}
