package com.vitorcamilodev.exercicio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitorcamilodev.exercicio.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
