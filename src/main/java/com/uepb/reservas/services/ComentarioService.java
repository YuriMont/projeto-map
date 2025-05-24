package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.ComentarioRequestDto;
import com.uepb.reservas.models.Comentario;
import com.uepb.reservas.models.Reserva;
import com.uepb.reservas.repositories.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class ComentarioService {
    Scanner i = new Scanner(System.in);
    Scanner s = new Scanner(System.in);

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

    private int avaliacaoReserva(){
        System.out.println("Avalie sua estadia: ");
        System.out.println("[5] - Muita boa");
        System.out.println("[4] - Boa");
        System.out.println("[3] - Mediana");
        System.out.println("[2] - Ruim");
        System.out.println("[1] - Muito ruim");
        System.out.println("[0] - Nunca mais piso nessa porra");
        int escolha = i.nextInt();
        while(escolha > 5 || escolha < 0){
            System.out.println("Opção inexistente. Tente novamente.");
            System.out.println("Escolha: ");
            escolha = i.nextInt();
        }
        return escolha;
    }

    public Comentario fazerComentario(Reserva reserva){
        System.out.println("Faça seu comentário/avaliação sobre sua experiencia");
        String textoComentario = s.nextLine();
        int avaliacao = avaliacaoReserva();
        Comentario comentario = new Comentario(reserva.getHospede(), reserva, textoComentario, avaliacao, reserva.getDataCheckout());

        return comentario;
    }
}
