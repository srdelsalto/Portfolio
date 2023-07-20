package com.srdelsalto.todobackend.swagger.application.query;

import com.srdelsalto.todobackend.swagger.domain.entities.ToDo;
import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetTodoTaskQuery implements Request<ToDo> {
    private String id;
}
