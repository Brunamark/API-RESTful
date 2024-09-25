package com.bruna.todosimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bruna.todosimple.models.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    
}
