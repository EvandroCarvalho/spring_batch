package com.spring.batch.repository;

import com.spring.batch.Entity.Cep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Evandro Carvalho
 */
@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {
}
