package com.uepb.reservas.models;

import com.uepb.reservas.dtos.requests.ReservaRequestDto;
import jakarta.persistence.*;
import lombok.*;

import com.uepb.reservas.enums.ReservaStatus;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
    private LocalDateTime dataCheckin;
    private LocalDateTime dataCheckout;
    @Enumerated(EnumType.ORDINAL)
    private ReservaStatus status;
    @ManyToOne
    @JoinColumn(name = "id_hospede")
    private Hospede hospede;
    @ManyToOne
    @JoinColumn(name = "id_quarto")
    private Quarto quarto;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pagamento_id", referencedColumnName = "id")
    private Pagamento pagamento;
    @ManyToMany
    @JoinTable(
            name = "reserva_servico",
            joinColumns = @JoinColumn(name = "reserva_id"),
            inverseJoinColumns = @JoinColumn(name = "servico_id")
    )
    private List<Servico> servicos;
    @ManyToMany
    @JoinTable(
            name = "reserva_consumo",
            joinColumns = @JoinColumn(name = "reserva_id"),
            inverseJoinColumns = @JoinColumn(name = "consumo_id")
    )
    private List<Consumo> consumos;

    public Reserva(Long id){
        this.id = id;
    }

    public Reserva (ReservaRequestDto requestDto){
        this.hospede = new Hospede(requestDto.id_hospede());
        this.quarto = new Quarto(requestDto.id_quarto());
        this.dataCheckin = requestDto.dataCheckin();
        this.dataCheckout = requestDto.dataCheckout();
        this.status = ReservaStatus.CONFIRMADA;
    }

    public Reserva (Long id, ReservaRequestDto requestDto){
        this.id = id;
        this.hospede = new Hospede(requestDto.id_hospede());
        this.quarto = new Quarto(requestDto.id_quarto());
        this.dataCheckin = requestDto.dataCheckin();
        this.dataCheckout = requestDto.dataCheckout();
    }

    public Double calcularValor(){
        Double somaConsumos = consumos.stream()
                .mapToDouble(item -> item.getQuantidade() * item.getPrecoUnitario())
                .sum();

        Double somaServicos = servicos.stream()
                .mapToDouble(item -> item.getValor())
                .sum();

        long diasEstadia = ChronoUnit.DAYS.between(dataCheckin, dataCheckout);
        Double valorEstadia = quarto.getPrecoDiaria() * diasEstadia;

        return somaConsumos + somaServicos + valorEstadia;
    }
}
