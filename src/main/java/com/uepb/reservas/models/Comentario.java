package com.uepb.reservas.models;

import com.uepb.reservas.dtos.requests.ComentarioRequestDto;
import com.uepb.reservas.enums.Avaliacao;
import jakarta.persistence.*;
import lombok.*;

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
    @Enumerated(EnumType.ORDINAL)
    private Avaliacao avaliacao;

    public Comentario (ComentarioRequestDto requestDto){
        this.hospede = new Hospede(requestDto.id_hospede());
        this.reserva = new Reserva(requestDto.id_reserva());
        this.comentario = requestDto.comentario();
        this.avaliacao = Avaliacao.values()[requestDto.avaliacao()];
    }

    public Comentario (Long id, ComentarioRequestDto requestDto){
        this.id = id;
        this.hospede = new Hospede(requestDto.id_hospede());
        this.reserva = new Reserva(requestDto.id_reserva());
        this.comentario = requestDto.comentario();
        this.avaliacao = Avaliacao.values()[requestDto.avaliacao()];
    }
}
