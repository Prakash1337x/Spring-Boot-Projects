package com.example.demo.controller;

import com.example.demo.service.TodoService;
import com.example.demo.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Slf4j used for log msg to console
@RequestMapping("/todo")
public class TodoController
{
    @Autowired
    private TodoService obj;

    // Create
    @PostMapping("/create")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo input)
    {
        return new ResponseEntity<Todo>(obj.createTodo(input), HttpStatus.CREATED);
    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id)
    {
        try
        {
            Todo getTodo = obj.getTodoById(id);
            return new ResponseEntity<Todo>(getTodo, HttpStatus.OK);
        }
        catch (Exception e)
        {
            //log.info("");
            //log.warn("");
            //log.error("", e);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // ReadAll
    @GetMapping
    public ResponseEntity<List<Todo>> getTodos()
    {
        return new ResponseEntity<>(obj.getTodos(), HttpStatus.OK);
    }

    // Update
    @PutMapping("/update")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo input)
    {
        return new ResponseEntity<>(obj.updateTodo(input), HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/delete")
    public void deleteTodo(@PathVariable Long id)
    {
        obj.deleteTodo(id);
    }

    // Pagination
    @GetMapping("/page")
    public ResponseEntity<Page<Todo>> getTodosByPages(@RequestParam int page, @RequestParam int size)
    {
        return new ResponseEntity<>(obj.getTodosByPages(page, size), HttpStatus.OK);
    }
}




/*@RestController
// Request Mapping - joins the "/api/todo"
@RequestMapping("/api/todo")
public class TodoController
{
    //@Autowired
    //private TodoService todo;
    @GetMapping("/get1")
    String getTodo1()
    {
        //todo.show();
        return "getTodo1";
    }

    @GetMapping("/get2")
    String getTodo2() { return "getTodo2"; }

    // Path Variable - args with integer
    @GetMapping("/{id}")
    String getId(@PathVariable int id) { return "TODO ID : "+id; }

    // Request Param - url ? key = value & key=value
    @GetMapping("/param")
    String getParam(@RequestParam("todoid") int id, @RequestParam("todoname") String name)
    {
        return "Param Id : "+id+" Param Name : "+name;
    }

    // Request Body - hide the username, pass in url
    @PostMapping("/body")
    String getBody(@RequestBody String body)
    {
        return "Body : "+body;
    }

    // Put Mapping - update the values
    @PutMapping("/{id}")
    String put(@PathVariable int id)
    {
        return "Put"+id;
    }

    // Delete Mapping - delete mapping
    @DeleteMapping("/{id}")
    String delete(@PathVariable int id)
    {
        return "Delete"+ id;
    }
} */
