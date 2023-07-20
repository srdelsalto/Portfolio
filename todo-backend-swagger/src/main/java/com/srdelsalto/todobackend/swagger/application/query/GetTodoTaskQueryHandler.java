package com.srdelsalto.todobackend.swagger.application.query;

import com.srdelsalto.todobackend.swagger.domain.entities.ToDo;
import com.srdelsalto.todobackend.swagger.domain.interfaces.ITodoRepository;
import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.util.NoSuchElementException;

@Component
public class GetTodoTaskQueryHandler implements RequestHandler<GetTodoTaskQuery, ToDo> {
    @Autowired
    private ITodoRepository repository;

    @Autowired
    private Mediator mediator;

    @Override
    public ToDo handle(GetTodoTaskQuery getTodoTaskQuery) {
        ToDo element = repository.findById(getTodoTaskQuery.getId());

        if (element != null){
            return element;
        }else{
            throw new NoSuchElementException("Todo Task not found");
        }
    }
}
