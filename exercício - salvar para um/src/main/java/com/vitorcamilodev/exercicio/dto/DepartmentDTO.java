package com.vitorcamilodev.exercicio.dto;

import com.vitorcamilodev.exercicio.entities.Department;

public class DepartmentDTO {

	private Long id;
    private String name;
    
    public DepartmentDTO() {

	}
    
    public DepartmentDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
    
    public DepartmentDTO(Department department) {
		id = department.getId();
		name = department.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
    
    
}
