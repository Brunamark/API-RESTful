package com.bruna.todosimple.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.bruna.todosimple.models.Task;
import com.bruna.todosimple.repositories.TaskRepository;
import com.bruna.todosimple.services.TaskService;
import com.bruna.todosimple.services.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/task")
@Validated
public class TaskController {

    private TaskService taskService;
    private TaskRepository taskRepository;
    private UserService userService;
    public TaskController(TaskService taskService, TaskRepository taskRepository,UserService userService) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        Task obj = this.taskService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    public List<Task> findAllById(Long userId){
        return this.taskRepository.findByUser_Id(userId);
    }
    @PostMapping
    @Validated
    public ResponseEntity<Void> create(@Valid @RequestBody Task obj) {
        this.taskService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping("/{id}")
    @Validated
    public ResponseEntity<Task> update(@Valid @RequestBody Task obj, @PathVariable Long id){
        obj.setId(id);
        this.taskService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Task>> findAllByUserId(@PathVariable Long id){
        this.userService.findById(id);
        List<Task> objs = this.taskService.findAllByUserId(id);
        return ResponseEntity.ok().body(objs);
    }

    
}
