package com.srdelsalto.todobackend.swagger.application.dtos.responses;

import com.srdelsalto.todobackend.swagger.domain.entities.ToDo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateToDoResponse {
    private String message;
    private ToDo todoItem;
}
