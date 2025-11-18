package com.vitorcamilodev.exercicio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitorcamilodev.exercicio.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
