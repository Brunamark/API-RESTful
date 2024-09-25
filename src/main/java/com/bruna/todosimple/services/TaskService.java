package com.bruna.todosimple.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.bruna.todosimple.models.Task;
import com.bruna.todosimple.models.User;
import com.bruna.todosimple.repositories.TaskRepository;
import jakarta.transaction.Transactional;

@Service
public class TaskService {
    
    private TaskRepository taskRepository;

    private UserService userService;

    public TaskService(TaskRepository taskRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    
    public Task findById(Long id){
        Optional<Task> task = this.taskRepository.findById(id);
        return task.orElseThrow(() -> new RuntimeException(
            "Tarefa não encontrada! Id:  " + id + ", Tipo: " + Task.class.getName()
        ));
    }

    @Transactional
    @SuppressWarnings("null")
    public Task create(Task obj){
        User user = this.userService.findById(obj.getUser().getId());
        obj.setId((Long) null);
        obj.setUser(user);
        obj = this.taskRepository.save(obj);
        return obj;
    }

    @Transactional
    public Task update(Task obj){
        Task newObj = findById(obj.getId());
        newObj.setDescription(obj.getDescription());
        return this.taskRepository.save(newObj);
    }

    public void delete(Long id){
        findById(id);
        this.taskRepository.deleteById(id);
    }
}
