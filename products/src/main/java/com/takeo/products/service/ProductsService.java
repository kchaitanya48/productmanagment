package com.takeo.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takeo.products.model.Products;
import com.takeo.products.repository.ProductsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductsService {
	@Autowired
	ProductsRepository productRepository;
	
	public Products getProduct(int productId) {
		return productRepository.findById(productId).get();
	}
	 public List<Products> getAllProducts() {
	        return productRepository.findAll();
	    }

	
		public void updateProductName(String productName,int productId) {
			productRepository.updateProductName(productName, productId);
		}
	 
		
		public Products saveProduct(Products products) {
			productRepository.save(products);
			return products;
		}
	 
	
}