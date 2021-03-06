package br.com.ifinance.repositories;

import br.com.ifinance.models.entities.Liability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiabilityRepository extends JpaRepository<Liability, Long> {
}
