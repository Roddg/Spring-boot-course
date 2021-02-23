package com.example.ulbittvspring.service;

import com.example.ulbittvspring.entity.TodoEntity;
import com.example.ulbittvspring.entity.UserEntity;
import com.example.ulbittvspring.model.Todo;
import com.example.ulbittvspring.repository.TodoRepo;
import com.example.ulbittvspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));

    }

    public Todo complete(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setComleted(!todo.getComleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
