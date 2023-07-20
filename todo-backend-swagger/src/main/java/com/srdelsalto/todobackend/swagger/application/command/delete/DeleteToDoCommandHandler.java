package com.srdelsalto.todobackend.swagger.application.command.delete;

import com.srdelsalto.todobackend.swagger.application.dtos.responses.DeleteToDoResponse;
import com.srdelsalto.todobackend.swagger.domain.interfaces.ITodoRepository;
import io.jkratz.mediator.core.Command;
import io.jkratz.mediator.core.CommandHandler;
import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteToDoCommandHandler implements RequestHandler<DeleteToDoCommand, DeleteToDoResponse> {
    @Autowired
    private ITodoRepository repository;

    @Autowired
    private Mediator mediator;

    @Override
    public DeleteToDoResponse handle(DeleteToDoCommand command) {
        DeleteToDoResponse response = new DeleteToDoResponse();
        String message = "";

        try {
            repository.delete(command.getId());
            message = "Registro eliminado correctamente!";
        } catch (Exception e){
            message = "Error en eliminación de registro!";
        } finally {
            response.setMessage(message);
        }

        return response;
    }
}
