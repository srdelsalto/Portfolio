package com.srdelsalto.todobackend.swagger.application.query;

import com.srdelsalto.todobackend.swagger.domain.entities.ToDo;
import com.srdelsalto.todobackend.swagger.domain.interfaces.ITodoRepository;
import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllTasksQueryHandler implements RequestHandler<GetAllTasksQuery, List<ToDo>> {
    @Autowired
    private ITodoRepository repository;

    @Autowired
    private Mediator mediator;

    @Override
    public List<ToDo> handle(GetAllTasksQuery getAllTasksQuery) {
        return repository.findAll();
    }
}
