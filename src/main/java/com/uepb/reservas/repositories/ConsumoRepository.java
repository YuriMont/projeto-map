package com.uepb.reservas.repositories;

import com.uepb.reservas.models.Consumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Long> {
}
