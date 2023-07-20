package com.srdelsalto.todobackend.swagger.infrastructure.repositories.todo;

import com.srdelsalto.todobackend.swagger.domain.entities.ToDo;
import com.srdelsalto.todobackend.swagger.domain.interfaces.ITodoRepository;
import com.srdelsalto.todobackend.swagger.infrastructure.persistance.mapper.ToDoMapper;
import com.srdelsalto.todobackend.swagger.infrastructure.repositories.jpa.ToDoJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ToDoRepository implements ITodoRepository {
    @Autowired
    private ToDoJPARepository jpaRepository;

    @Autowired
    private ToDoMapper mapper;

    @Override
    @Transactional
    public String save(ToDo todo) {
        return jpaRepository.save(mapper.toModel(todo)).getId();
    }

    @Override
    public List<ToDo> findAll() {
        return mapper.toEntities(jpaRepository.findAll());
    }

    @Override
    public ToDo findById(String id) {
        var obj = jpaRepository.findById(id).map(model -> mapper.toEntity(model));
        if(obj.isPresent()){
            return obj.get();
        }
        return null;
    }

    @Override
    @Transactional
    public void update(ToDo todo) {
        var model = mapper.toModel(todo);

        jpaRepository.save(model);
    }

    @Override
    @Transactional
    public void delete(String id) {
        jpaRepository.deleteById(id);
    }
}
