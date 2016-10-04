package org.houor.spring.datajpa.service;

import java.util.List;

import org.houor.spring.datajpa.domain.Product;
import org.houor.spring.datajpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public void save(Product p) {
		productRepository.save(p);
	}
	
	
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}


	public Product findByID(Long id) {
		return productRepository.findOne(id);
	}


	public Page<Product> findByName(String string, Pageable pageable) {
		return productRepository.findByName(string, pageable);
	}


	public List<Product> findByDescription(String description) {
		return productRepository.findByDescription(description);
	}
	
	

}
