package com.srdelsalto.todobackend.swagger.application.command.create;

import com.srdelsalto.todobackend.swagger.application.dtos.request.CreateToDoRequest;
import com.srdelsalto.todobackend.swagger.application.dtos.responses.CreateToDoResponse;
import io.jkratz.mediator.core.Request;

public class CreateToDoCommand extends CreateToDoRequest implements Request<CreateToDoResponse> {
    public CreateToDoCommand() {
        super();
    }
}
