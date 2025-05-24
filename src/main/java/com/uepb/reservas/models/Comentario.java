package com.uepb.reservas.models;

import com.uepb.reservas.dtos.requests.ComentarioRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comentario extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_hospede", nullable = false)
    private Hospede hospede;
    @ManyToOne
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reserva reserva;
    @Column(columnDefinition = "TEXT")
    private String comentario;
    private int avaliacao;
    private Date dataComentario;

    public Comentario(Hospede hospede, Reserva reserva, String comentario, int avaliacao, Date dataComentario){
        this.hospede = hospede;
        this.reserva = reserva;
        this.comentario = comentario;
        this.avaliacao = avaliacao;
        this.dataComentario = dataComentario;
    }

    public Comentario (ComentarioRequestDto requestDto){
        this.hospede = new Hospede(requestDto.id_hospede());
        this.reserva = new Reserva(requestDto.id_reserva());
        this.comentario = requestDto.comentario();
        this.avaliacao = requestDto.avaliacao();
        this.dataComentario = requestDto.dataComentario();
    }

    public Comentario (Long id, ComentarioRequestDto requestDto){
        this.id = id;
        this.hospede = new Hospede(requestDto.id_hospede());
        this.reserva = new Reserva(requestDto.id_reserva());
        this.comentario = requestDto.comentario();
        this.avaliacao = requestDto.avaliacao();
        this.dataComentario = requestDto.dataComentario();
    }
}
