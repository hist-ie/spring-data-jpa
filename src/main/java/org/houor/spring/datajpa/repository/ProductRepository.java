package org.houor.spring.datajpa.repository;

import org.houor.spring.datajpa.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Page<Product> findByName(String name, Pageable pageable);

}
