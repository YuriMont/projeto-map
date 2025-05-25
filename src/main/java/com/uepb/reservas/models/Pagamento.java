package com.uepb.reservas.models;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName.Form;

import com.uepb.reservas.dtos.requests.PagamentoRequestDto;
import lombok.*;

import com.uepb.reservas.enums.FormaPagamento;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pagamento extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "reserva_id", referencedColumnName = "id")
    private Reserva reserva;
    private Double valorPago;
    @Enumerated(EnumType.ORDINAL)
    private FormaPagamento formaPagamento;
    
    public Pagamento (PagamentoRequestDto requestDto, Reserva reserva){
        this.reserva = reserva;
        this.valorPago = reserva.calcularValor();
        this.formaPagamento =  requestDto.formaPagamento();
    }

}
