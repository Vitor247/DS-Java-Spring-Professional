package com.vitorcamilodev.exercicio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitorcamilodev.exercicio.dto.PersonDTO;
import com.vitorcamilodev.exercicio.dto.PersonDepartmentDTO;
import com.vitorcamilodev.exercicio.entities.Department;
import com.vitorcamilodev.exercicio.entities.Person;
import com.vitorcamilodev.exercicio.repositories.DepartmentRepository;
import com.vitorcamilodev.exercicio.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	//Salva com entidade associada
	public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {
		Person person = new Person();
		person.setName(dto.getName());
		person.setSalary(dto.getSalary());
		
		Department department = departmentRepository.getReferenceById(dto.getDepartment().getId());
		
		person.setDepartment(department);
		
		person = repository.save(person);
		
		return new PersonDepartmentDTO(person);
	}
	
	public PersonDTO insert(PersonDTO dto) {
		Person person = new Person();
		person.setName(dto.getName());
		person.setSalary(dto.getSalary());
		
		Department department = departmentRepository.getReferenceById(dto.getDepartmentId());
		
		person.setDepartment(department);
		
		person = repository.save(person);
		
		return new PersonDTO(person);
	}

}
