package com.example.demo.repository;

import com.example.demo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


// Provides CRUD
public interface TodoRepository extends JpaRepository<Todo, Long>
{

}
