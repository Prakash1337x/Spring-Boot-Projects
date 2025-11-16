package com.project.todoapp.service;

import com.project.todoapp.models.Todo;
import com.project.todoapp.repository.TodoRepository;
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
    private TodoRepository todorepository;

    // Create
    public Todo createTodo(Todo input)
    {

        return todorepository.save(input);
    }

    // Read
    public Todo getTodoById(Long id)
    {
        return todorepository.findById(id).orElseThrow(() -> new RuntimeException("Todo Not Found!.."));
    }

    // ReadAll
    public List<Todo> getTodos()
    {
        return todorepository.findAll();
    }

    // Update
    public Todo updateTodo(Todo input)
    {
        return todorepository.save(input);
    }

    // Delete
    public void deleteTodoById(Long id)
    {
        todorepository.deleteById(id);
    }

    // DeleteAll
    public void deleteTodos()
    {
        todorepository.deleteAll();
    }

    // Pagination
    public Page<Todo> getTodosByPages(int page, int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return todorepository.findAll(pageable);
    }
}
