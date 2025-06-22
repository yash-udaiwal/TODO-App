package com.app.todoApp.controller;

import com.app.todoApp.models.Task;
import com.app.todoApp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class todoAppController {

    private final TaskService taskService;

    public todoAppController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTask(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping
    public String addTask(@RequestParam String title)
    {
        taskService.addTask(title);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/toggle/{id}")
    public String toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/";
    }
}
