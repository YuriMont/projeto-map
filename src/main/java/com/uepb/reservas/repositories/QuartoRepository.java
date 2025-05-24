package com.uepb.reservas.repositories;

import com.uepb.reservas.models.Quarto;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {

    List<Quarto> findDisponiveisPorTipo(Long id_quarto, Date checkIn, Date checkOut);
}
