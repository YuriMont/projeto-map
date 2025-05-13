package com.uepb.reservas.services;

import com.uepb.reservas.models.Comentario;
import com.uepb.reservas.repositories.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository repository;

    public Comentario createComentario(Comentario cmt){
        return repository.save(cmt);
    }

    public List<Comentario> findComentario(){
        return repository.findAll();
    }
}
