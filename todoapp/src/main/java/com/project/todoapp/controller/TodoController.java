package com.project.todoapp.controller;

import com.project.todoapp.models.Todo;
import com.project.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController
{
    @Autowired
    private TodoService todoService;

    // Create
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo input)
    {
        System.out.println("Created");
        return new ResponseEntity<Todo>(todoService.createTodo(input), HttpStatus.CREATED);
    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable() Long id)
    {
        try
        {
            Todo getTodo = todoService.getTodoById(id);
            return new ResponseEntity<Todo>(getTodo, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // ReadAll
    @GetMapping
    public ResponseEntity<List<Todo>> getTodos()
    {
        System.out.println("ReadAll");
        return new ResponseEntity<>(todoService.getTodos(), HttpStatus.OK);
    }

    // Update
    @PutMapping
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo input)
    {
        return new ResponseEntity<>(todoService.updateTodo(input), HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodoById(@PathVariable Long id)
    {
        todoService.deleteTodoById(id);
        return ResponseEntity.ok("Todo with Id : "+id+" Deleted!..");
    }

    // DeleteAll
    @DeleteMapping
    public ResponseEntity<String> deleteTodos()
    {
        todoService.deleteTodos();
        return ResponseEntity.ok("All Todos Deleted!..");
    }

    // Pagination
    @GetMapping("/page")
    public ResponseEntity<Page<Todo>> getTodosByPages(@RequestParam int page, @RequestParam int size)
    {
        return new ResponseEntity<>(todoService.getTodosByPages(page, size), HttpStatus.OK);
    }
}

