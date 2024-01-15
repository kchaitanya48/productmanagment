package com.takeo.products.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.takeo.products.model.Products;
import com.takeo.products.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductsService productsService;

	@GetMapping("/{id}")
	public Products getProduct(@PathVariable("id") int id) {

		return productsService.getProduct(id);
	}

	@GetMapping
	public List<Products> getAllProducts() {
		return productsService.getAllProducts();
	}

	@PostMapping
	public Products saveProducts(@RequestBody Products products) {
		return productsService.saveProduct(products);
	}

	@PutMapping("name/{name}/productId/{productId}")

	public ResponseEntity<String> updateProductName(@PathVariable("name") String productName,
			@PathVariable("productId") int productId) {

		productsService.updateProductName(productName, productId);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
}
