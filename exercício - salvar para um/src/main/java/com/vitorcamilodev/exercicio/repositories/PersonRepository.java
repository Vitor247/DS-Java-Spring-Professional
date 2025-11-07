package com.vitorcamilodev.exercicio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitorcamilodev.exercicio.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
