package com.vitorcamilodev.exercicio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitorcamilodev.exercicio.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
