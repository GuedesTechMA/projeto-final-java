package com.trabalhofinal.trabalhofinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalhofinal.trabalhofinal.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
