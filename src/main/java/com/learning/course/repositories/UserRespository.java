package com.learning.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.course.entities.User;

@Repository
public interface UserRespository extends JpaRepository<User, Integer>{

}
