package com.learning.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.course.entities.Order;

@Repository
public interface OrderRespository extends JpaRepository<Order, Integer>{

}
