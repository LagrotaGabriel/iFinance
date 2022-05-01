package br.com.ifinance.repositories;

import br.com.ifinance.models.entities.Inflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InflowRepository extends JpaRepository<Inflow, Long> {
}
