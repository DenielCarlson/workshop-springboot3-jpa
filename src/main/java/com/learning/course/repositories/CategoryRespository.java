package com.learning.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.course.entities.Category;

@Repository
public interface CategoryRespository extends JpaRepository<Category, Integer>{

}
