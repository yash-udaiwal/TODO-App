package com.app.todoApp.services;

import com.app.todoApp.models.Task;
import com.app.todoApp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    public void addTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        repo.save(task);
    }

    public void deleteTask(Long id) {
        repo.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = repo.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Invalid Task ID"));
        task.setCompleted(!task.isCompleted());
        repo.save(task);
    }
}
