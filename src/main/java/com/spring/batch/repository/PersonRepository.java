package com.spring.batch.repository;

import com.spring.batch.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Evandro Carvalho
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
