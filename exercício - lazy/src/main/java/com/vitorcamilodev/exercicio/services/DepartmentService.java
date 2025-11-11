package com.vitorcamilodev.exercicio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorcamilodev.exercicio.dto.DepartmentDTO;
import com.vitorcamilodev.exercicio.dto.EmployeeMinDTO;
import com.vitorcamilodev.exercicio.entities.Department;
import com.vitorcamilodev.exercicio.entities.Employee;
import com.vitorcamilodev.exercicio.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;

	@Transactional(readOnly = true)
	public DepartmentDTO findById(Long id) {
		Optional<Department> result = repository.findById(id);
		return new DepartmentDTO(result.get());
	}

	@Transactional(readOnly = true)
	public List<EmployeeMinDTO> findEmployeesByDepartment(Long id) {
		Optional<Department> result = repository.findById(id);
		List<Employee> list = result.get().getEmployees();
		return list.stream().map(x -> new EmployeeMinDTO(x)).toList();
	}
}
