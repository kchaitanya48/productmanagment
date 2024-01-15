package com.takeo.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.takeo.products.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer>{
	@Modifying
    @Query("UPDATE Products p SET p.productName = :productName WHERE p.productId = :productId")
    void updateProductName(@Param("productName") String productName,@Param("productId") int productId);
}
