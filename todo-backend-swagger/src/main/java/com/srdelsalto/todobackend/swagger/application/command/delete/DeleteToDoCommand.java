package com.srdelsalto.todobackend.swagger.application.command.delete;

import com.srdelsalto.todobackend.swagger.application.dtos.responses.DeleteToDoResponse;
import io.jkratz.mediator.core.Command;
import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteToDoCommand implements Request<DeleteToDoResponse> {
    private String id;
}
