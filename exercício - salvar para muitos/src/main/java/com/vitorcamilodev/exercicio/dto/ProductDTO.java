package com.vitorcamilodev.exercicio.dto;

import java.util.ArrayList;
import java.util.List;

import com.vitorcamilodev.exercicio.entities.Category;
import com.vitorcamilodev.exercicio.entities.Product;

public class ProductDTO {

	private Long id;
	private String name;
	private Double price;
	
	private List<CategoryDTO> categories = new ArrayList<>();
	
	public ProductDTO() {

	}

	public ProductDTO(Long id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public ProductDTO(Product product) {
		id = product.getId();
		name = product.getName();
		price = product.getPrice();
		for(Category cat : product.getCategories()) {
			categories.add(new CategoryDTO(cat));
		}
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}
	
}
