package com.srdelsalto.todobackend.swagger.application.command.update;

import com.srdelsalto.todobackend.swagger.application.dtos.responses.UpdateStatusResponse;
import com.srdelsalto.todobackend.swagger.domain.entities.ToDo;
import com.srdelsalto.todobackend.swagger.domain.interfaces.ITodoRepository;
import io.jkratz.mediator.core.CommandHandler;
import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateStatusCommandHandler implements RequestHandler<UpdateStatusCommand, UpdateStatusResponse> {
    @Autowired
    private ITodoRepository repository;

    @Autowired
    private Mediator mediator;

    @Override
    public UpdateStatusResponse handle(UpdateStatusCommand updateStatusCommand) {
        String message = "";
        UpdateStatusResponse response = new UpdateStatusResponse();

        try {
            ToDo todoItem = repository.findById(updateStatusCommand.getId());
            todoItem.setStatus(!todoItem.getStatus());
            repository.save(todoItem);

            message = "Item con el id: " + todoItem.getId() + " ha sido actualizado al estado: " + todoItem.getStatus();
        } catch (Exception e) {
            message = "Error en actualización!";
        } finally {
            response.setMessage(message);
        }

        return response;
    }
}
