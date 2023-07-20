package com.srdelsalto.todobackend.swagger.application.command.update;

import com.srdelsalto.todobackend.swagger.application.dtos.request.UpdateToDoRequest;
import com.srdelsalto.todobackend.swagger.application.dtos.responses.UpdateToDoResponse;
import io.jkratz.mediator.core.Request;

public class UpdateToDoCommand extends UpdateToDoRequest implements Request<UpdateToDoResponse> {
}
