package com.vitorcamilodev.exercicio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitorcamilodev.exercicio.dto.CategoryDTO;
import com.vitorcamilodev.exercicio.dto.ProductDTO;
import com.vitorcamilodev.exercicio.entities.Category;
import com.vitorcamilodev.exercicio.entities.Product;
import com.vitorcamilodev.exercicio.repositories.CategoryRepository;
import com.vitorcamilodev.exercicio.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public ProductDTO insert(ProductDTO dto) {
		Product product = new Product();	
	
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		
		for(CategoryDTO catDto : dto.getCategories()) {
			Category cat = categoryRepository.getReferenceById(catDto.getId());
			
//			Category cat = new Category();
//			cat.setId(catDto.getId());
			product.getCategories().add(cat);
		}
		
		product =  repository.save(product);
		
		return new ProductDTO(product);
	}
}
