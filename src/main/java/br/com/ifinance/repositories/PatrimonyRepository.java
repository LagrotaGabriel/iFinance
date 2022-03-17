package br.com.ifinance.repositories;

import br.com.ifinance.models.entities.Patrimony;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatrimonyRepository extends JpaRepository<Patrimony, Long> {
}
