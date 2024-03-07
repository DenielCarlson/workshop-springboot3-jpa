package com.learning.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.course.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
