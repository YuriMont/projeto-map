package com.uepb.reservas.repositories;

import com.uepb.reservas.models.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoReposiroty extends JpaRepository<Quarto, Long> {
}
