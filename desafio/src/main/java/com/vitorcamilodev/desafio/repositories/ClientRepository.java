package com.vitorcamilodev.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitorcamilodev.desafio.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
