package com.example.todoapp.models;
import java.time.format.DateTimeFormatter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Entity
@Table(name = "tbl_todo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo{

    @Id
    @GeneratedValue
    public Integer id;

    @Column(nullable = false)
    public String name;

    public String description;

    @Column(nullable = false)
    public Boolean isDone;

    private String createdAt;

    private String lastModifiedAt;

}
