package com.trabalhofinal.trabalhofinal.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhofinal.trabalhofinal.entities.Product;
import com.trabalhofinal.trabalhofinal.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<Product> findAll() {
		
		
		List<Product> list = productRepository.findAll();
		
		return list;
	}
	
	@GetMapping(value = "/{id}")
	public Product findById(@PathVariable Long id) {
		Product result = productRepository.findById(id).get();
		return result;
	}
	
	@PostMapping
	public Product insert(@RequestBody Product product) {
		Product result = productRepository.save(product);
		return result;
	}
	
	@PutMapping("/{id}")
	public Product update(@PathVariable Long id, @RequestBody Product novoProduct) {
	    Optional<Product> productOptional = productRepository.findById(id);

	    if (productOptional.isPresent()) {
	        Product product = productOptional.get();
	        product.setName(novoProduct.getName()); 

	        
	        Product resultado = productRepository.save(product);

	        return resultado;
	    } else {
	       
	        return null;
	    }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
	    Optional<Product> productOptional = productRepository.findById(id);
	    
	    if (productOptional.isPresent()) {
	        productRepository.deleteById(id);
	        return ResponseEntity.ok().build();
	    } else {
	        
	        return ResponseEntity.notFound().build();
	    }
	}




}
