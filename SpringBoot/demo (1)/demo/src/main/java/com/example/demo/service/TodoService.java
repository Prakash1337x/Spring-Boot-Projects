package com.example.demo.service;

import com.example.demo.models.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService
{
    @Autowired
    private TodoRepository obj;

    // Create
    public Todo createTodo(Todo input)
    {
         return obj.save(input);
    }

    // Read
    public Todo getTodoById(Long id)
    {
        return obj.findById(id).orElseThrow(()-> new RuntimeException("Todo Not Found!.."));
    }

    // ReadAll
    public List<Todo> getTodos()
    {
        return obj.findAll();
    }

    // Update
    public Todo updateTodo(Todo input)
    {
        return obj.save(input);
    }

    // Delete
    public void deleteTodo(Long id)
    {
        obj.deleteById(id);
    }

    // Pagination
    public Page<Todo> getTodosByPages(int page, int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return obj.findAll(pageable);
    }
}