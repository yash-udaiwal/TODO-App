package com.app.todoApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data //combination of annotation like @ToString, @Getter, @Setter, @EqualAndHashCode, @RequiredArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //will create values for id field automatically
    private Long id;
    private String title;
    private boolean completed;
}
