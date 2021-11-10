package com.github.fabriciolfj.productservice.domain.repository;


import com.github.fabriciolfj.productservice.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
