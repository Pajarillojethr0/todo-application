package com.example.todoapp.controllers;

import com.example.todoapp.models.Todo;
import com.example.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> getAllTodo(){
        return todoService.getAllTodo();
    }

    @PostMapping ("/create-todo")
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }

    @DeleteMapping("/delete-todo/{id}")
    public void deleteTodo(@PathVariable Integer id){
        todoService.deleteTodoById(id);
    }

    @PatchMapping("/update_todo/status/{id}")
    public Todo updateTodoStatus(
                           @PathVariable Integer id,
                           @RequestBody Map<String, Boolean> requestBody){
        Boolean status = requestBody.get("isDone");
        return todoService.updateTodoStatus(id, status);
    }

    @GetMapping("/search/{string}")
    public List<Todo> searchString(@PathVariable String string){
        return todoService.searchString(string);
    }

}
