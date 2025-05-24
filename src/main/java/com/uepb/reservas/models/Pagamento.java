package com.uepb.reservas.models;

import org.springframework.boot.context.properties.source.ConfigurationPropertyName.Form;

import com.uepb.reservas.dtos.requests.PagamentoRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import lombok.*;

import com.uepb.reservas.enums.FormaPagamento;

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
    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;
    private Double valorPago;
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;
    
    public Pagamento (PagamentoRequestDto requestDto){
        this.reserva = new Reserva(requestDto.id_reserva());
        this.valorPago = requestDto.valorPago();
        this.formaPagamento =  requestDto.formaPagamento();
    }

    public Pagamento (Long id, PagamentoRequestDto requestDto){
        this.id = id;
        this.reserva = new Reserva(requestDto.id_reserva());
        this.valorPago = requestDto.valorPago();
        this.formaPagamento =  requestDto.formaPagamento();
    }
}
