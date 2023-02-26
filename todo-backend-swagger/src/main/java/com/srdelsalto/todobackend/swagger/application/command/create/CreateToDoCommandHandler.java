package com.srdelsalto.todobackend.swagger.application.command.create;

import com.srdelsalto.todobackend.swagger.application.dtos.responses.CreateToDoResponse;
import com.srdelsalto.todobackend.swagger.domain.entities.ToDo;
import com.srdelsalto.todobackend.swagger.domain.interfaces.ITodoRepository;
import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CreateToDoCommandHandler implements RequestHandler<CreateToDoCommand, CreateToDoResponse> {
    @Autowired
    private ITodoRepository repository;

    @Autowired
    private Mediator mediator;

    @Override
    public CreateToDoResponse handle(CreateToDoCommand createToDoCommand) {
        ToDo todoItem = new ToDo();
        todoItem.setName(createToDoCommand.getName());
        CreateToDoResponse response = new CreateToDoResponse();
        String message = "";

        try {
            String id = repository.save(todoItem);
            message = "Item creado correctamente";

            todoItem = repository.findById(id);

        } catch (Exception e) {
            message = "Error en creación!";
            todoItem = new ToDo();
        }

        response.setMessage(message);
        response.setTodoItem(todoItem);

        return response;
    }
}
