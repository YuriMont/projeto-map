package com.uepb.reservas.repositories;

import com.uepb.reservas.models.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Pagamento, Long> {
}
