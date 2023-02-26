package com.srdelsalto.todobackend.swagger.domain.interfaces;

import com.srdelsalto.todobackend.swagger.domain.entities.ToDo;

import java.util.List;
import java.util.Optional;

public interface ITodoRepository {
    String save(ToDo todo);
    List<ToDo> findAll();
    ToDo findById(String id);
    void update(ToDo todo);
}
