package com.example.todoapp.service;

import com.example.todoapp.exception.ResourceNotFoundException;
import com.example.todoapp.models.Todo;
import com.example.todoapp.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    public Todo createTodo(Todo todo) {

        todo.setCreatedAt(dateToString());
        todo.setIsDone(false);
        return todoRepository.save(todo);
    }

    public void deleteTodoById(Integer id) {
        todoRepository.deleteById(id);
    }

    public Todo updateTodoStatus(
                           Integer id, Boolean status) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found"));

        todo.setIsDone(status);

        todo.setLastModifiedAt(dateToString());

       return todoRepository.save(todo);
    }

    public String dateToString(){
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd");
        return now.format(formatter);
    }

    public List<Todo> searchString(String string) {
        return todoRepository.searchByString(string);
    }

}
