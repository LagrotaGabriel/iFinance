package br.com.ifinance.repositories;

import br.com.ifinance.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select u From User u where u.username = ?1")
    Optional<User> findByUsername(@Param("username") String username);

    @Query("Select u From User u where u.email = ?1")
    Optional<User> findByEmail(@Param("email") String email);
}
