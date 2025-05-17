package com.uepb.reservas.models;

import com.uepb.reservas.dtos.requests.ReservaRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Id;
import lombok.*;

import com.uepb.reservas.enums.ReservaStatus;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reserva extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataCheckin;
    private Date dataCheckout;
    @Enumerated(EnumType.STRING)
    private ReservaStatus status;
    @ManyToOne
    @JoinColumn(name = "id_hospede")
    private Hospede hospede;
    @ManyToOne
    @JoinColumn(name = "id_quarto")
    private Quarto quarto;
    @OneToMany(mappedBy = "reserva")
    private List<Pagamento> pagamentos;

    public Reserva(Long id){
        this.id = id;
    }

    public Reserva (ReservaRequestDto requestDto){
        this.hospede = new Hospede(requestDto.id_hospede());
        this.quarto = new Quarto(requestDto.id_quarto());
        this.dataCheckin = requestDto.dataCheckin();
        this.dataCheckout = requestDto.dataCheckout();
        this.status = requestDto.status();
    }

    public Reserva (Long id, ReservaRequestDto requestDto){
        this.id = id;
        this.hospede = new Hospede(requestDto.id_hospede());
        this.quarto = new Quarto(requestDto.id_quarto());
        this.dataCheckin = requestDto.dataCheckin();
        this.dataCheckout = requestDto.dataCheckout();
        this.status = requestDto.status();
    }
}
