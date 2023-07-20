package com.srdelsalto.todobackend.swagger.application.command.update;

import com.srdelsalto.todobackend.swagger.application.dtos.responses.UpdateStatusResponse;
import io.jkratz.mediator.core.Command;
import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStatusCommand implements Request<UpdateStatusResponse> {
    private String id;
}
