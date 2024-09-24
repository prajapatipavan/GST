package com.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.ProductEntity;

public interface ProductRepositry extends JpaRepository<ProductEntity,Integer> {

}
