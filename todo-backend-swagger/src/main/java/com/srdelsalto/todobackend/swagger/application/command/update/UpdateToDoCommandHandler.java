package com.srdelsalto.todobackend.swagger.application.command.update;

import com.srdelsalto.todobackend.swagger.application.dtos.responses.UpdateToDoResponse;
import com.srdelsalto.todobackend.swagger.domain.entities.ToDo;
import com.srdelsalto.todobackend.swagger.domain.interfaces.ITodoRepository;
import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UpdateToDoCommandHandler implements RequestHandler<UpdateToDoCommand, UpdateToDoResponse> {
    @Autowired
    private ITodoRepository repository;

    @Autowired
    private Mediator mediator;

    @Override
    public UpdateToDoResponse handle(UpdateToDoCommand updateToDoCommand) {
        String message = "";
        UpdateToDoResponse response = new UpdateToDoResponse();

        try {
            ToDo todoItem = repository.findById(updateToDoCommand.getId());

            if (Objects.nonNull(updateToDoCommand.getTitle()) && !"".equalsIgnoreCase(updateToDoCommand.getTitle())){
                todoItem.setTitle(updateToDoCommand.getTitle());
            }

            if (Objects.nonNull(updateToDoCommand.getDescription()) && !"".equalsIgnoreCase(updateToDoCommand.getDescription())){
                todoItem.setDescription(updateToDoCommand.getDescription());
            }

            todoItem.setStatus(!todoItem.getStatus());
            repository.save(todoItem);

            message = "Item con el id: " + todoItem.getId() + " ha sido actualizado con éxito!";
        } catch (Exception e) {
            message = "Error en actualización!";
        } finally {
            response.setMessage(message);
        }

        return response;
    }
}
