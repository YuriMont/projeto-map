package com.uepb.reservas.models;

import com.uepb.reservas.enums.ReservaStatus;
import jakarta.persistence.*;
import lombok.*;

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
    private Date dateCheckout;
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
}
