package com.example.todoapp.repositories;

import com.example.todoapp.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Query(value = "SELECT * FROM tbl_todo WHERE name LIKE %:string% OR description LIKE %:string%", nativeQuery = true)
    List<Todo>searchByString(String string);
}
