package com.srdelsalto.todobackend.swagger.application.query;

import com.srdelsalto.todobackend.swagger.domain.entities.ToDo;
import io.jkratz.mediator.core.Request;

import java.util.List;

public class GetAllTasksQuery implements Request<List<ToDo>> {
}
