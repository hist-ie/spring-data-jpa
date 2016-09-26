package org.houor.spring.datajpa.service;

import org.houor.spring.datajpa.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
	
	public void save(Product p);
	
	public Iterable<Product> findAll();
	
	Product findByID(Long id);

	public Page<Product> findByName(String string, Pageable pageable);

}
