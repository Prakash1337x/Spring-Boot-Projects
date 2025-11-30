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
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo)
    {
        System.out.println("created");
        return new ResponseEntity<Todo>(todoService.createTodo(todo), HttpStatus.CREATED);
    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity<Todo> readTodoById(@PathVariable() Long id)
    {
        try
        {
            Todo getTodo = todoService.readTodoById(id);
            return new ResponseEntity<Todo>(getTodo, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // ReadAll
    @GetMapping
    public ResponseEntity<List<Todo>> readTodos()
    {
        System.out.println("ReadAll");
        return new ResponseEntity<>(todoService.readTodos(), HttpStatus.OK);
    }

    // Update
    @PutMapping
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo)
    {
        return new ResponseEntity<>(todoService.updateTodo(todo), HttpStatus.OK);
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

