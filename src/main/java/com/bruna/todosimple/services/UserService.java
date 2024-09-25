package com.bruna.todosimple.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.bruna.todosimple.models.User;
import com.bruna.todosimple.repositories.TaskRepository;
import com.bruna.todosimple.repositories.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class UserService {
    private UserRepository userRepository;

    private TaskRepository taskRepository;

    
    public UserService(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }


    public User findById(Long id){
        Optional<User> user  = this.userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException(
            "Usuário não encontrado! Id: " + id + ", Tipo: " + User.class.getName()
        ));
    }

    @Transactional
    public User create(User obj){
        obj.setId(null);
        obj = this.userRepository.save(obj);
        this.taskRepository.saveAll(obj.getTasks());
        return obj;
    }

    @Transactional
    public User update(User obj){
        User newObj = findById(obj.getId());
        newObj.setPassword(obj.getPassword());
        return this.userRepository.save(newObj);
    }

    public void deleteById(Long id){
        findById(id);
        try{
            this.userRepository.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException( "Não é possível excluir pos hái entidade relacionada");
        }
    }

    
}
