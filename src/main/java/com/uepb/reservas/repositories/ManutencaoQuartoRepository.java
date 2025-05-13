package com.uepb.reservas.repositories;

import com.uepb.reservas.models.ManutencaoQuarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManutencaoQuartoRepository extends JpaRepository<ManutencaoQuarto, Long> {
}
