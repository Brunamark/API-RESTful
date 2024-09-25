package com.bruna.todosimple.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.bruna.todosimple.models.User;
import com.bruna.todosimple.repositories.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class UserService {
    private UserRepository userRepository;


    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User findById(Long id){
        Optional<User> user  = this.userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException(
            "Usuário não encontrado! Id: " + id + ", Tipo: " + User.class.getName()
        ));
    }

    @Transactional
    public User create(User obj){
        obj.setId((Long)null);
        obj = this.userRepository.save(obj);
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
