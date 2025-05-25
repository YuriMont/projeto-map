package com.uepb.reservas.models;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Hotel{
    private List<Hospede> hospedes;
    private List<Quarto> quartos;
    private List<Fornecedor> fornecedores;
}
