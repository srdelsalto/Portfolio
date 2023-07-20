package com.srdelsalto.todobackend.swagger.controllers;

import com.srdelsalto.todobackend.swagger.application.command.create.CreateToDoCommand;
import com.srdelsalto.todobackend.swagger.application.command.delete.DeleteToDoCommand;
import com.srdelsalto.todobackend.swagger.application.command.update.UpdateStatusCommand;
import com.srdelsalto.todobackend.swagger.application.command.update.UpdateToDoCommand;
import com.srdelsalto.todobackend.swagger.application.dtos.responses.CreateToDoResponse;
import com.srdelsalto.todobackend.swagger.application.dtos.responses.DeleteToDoResponse;
import com.srdelsalto.todobackend.swagger.application.dtos.responses.UpdateStatusResponse;
import com.srdelsalto.todobackend.swagger.application.dtos.responses.UpdateToDoResponse;
import com.srdelsalto.todobackend.swagger.application.query.GetAllTasksQuery;
import com.srdelsalto.todobackend.swagger.application.query.GetTodoTaskQuery;
import com.srdelsalto.todobackend.swagger.domain.entities.ToDo;
import io.jkratz.mediator.core.Mediator;
import lombok.extern.slf4j.Slf4j;
import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin("*")
@Slf4j
public class ToDoController {
    public static final String SENDING_COMMAND = "----- Sending command: {} {}";
    public static final String SENDING_QUERY = "------ Sending query: {} {}";

    @Autowired
    private Mediator mediator;

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getTodoTask(@PathVariable("id") String taskId){
        GetTodoTaskQuery query = new GetTodoTaskQuery();

        log.info(SENDING_QUERY, query.getClass().getName(), query);

        PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
        String safeId = policy.sanitize(taskId);

        query.setId(safeId);

        return new ResponseEntity<>(this.mediator.dispatch(query), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ToDo>> getTodoTasks(){
        GetAllTasksQuery query = new GetAllTasksQuery();

        log.info(SENDING_QUERY, query.getClass().getName(), query);

        return new ResponseEntity<>(this.mediator.dispatch(query), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreateToDoResponse> createToDoTask(@Valid @RequestBody CreateToDoCommand command){
        try {
            CreateToDoCommand safeCommand = new CreateToDoCommand();
            log.info(SENDING_COMMAND, command.getClass().getName(), command);

            PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
            String safeParameterTitle = policy.sanitize(command.getTitle());
            String safeParameterDescription = policy.sanitize(command.getDescription());
            safeCommand.setTitle(safeParameterTitle);
            safeCommand.setDescription(safeParameterDescription);

            return new ResponseEntity<>(this.mediator.dispatch(safeCommand), HttpStatus.CREATED);
        }catch (ResponseStatusException e){
            log.error("{}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<UpdateStatusResponse> updateStatus(@PathVariable("id") String taskId){
        try {
            UpdateStatusCommand safeCommand = new UpdateStatusCommand();
            log.info(SENDING_COMMAND, safeCommand.getClass().getName(), safeCommand);

            PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
            String safeId = policy.sanitize(taskId);

            safeCommand.setId(safeId);
            return new ResponseEntity<>(this.mediator.dispatch(safeCommand), HttpStatus.CREATED);
        }catch (ResponseStatusException e){
            log.error("{}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<UpdateToDoResponse> updateTodoTask(@RequestBody @Valid UpdateToDoCommand updateToDoCommand){
        try {
            UpdateToDoCommand safeCommand = new UpdateToDoCommand();
            log.info(SENDING_COMMAND, safeCommand.getClass().getName(), safeCommand);

            PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
            String safeId = policy.sanitize(updateToDoCommand.getId());

            safeCommand.setId(safeId);
            safeCommand.setTitle(updateToDoCommand.getTitle());
            safeCommand.setDescription(updateToDoCommand.getDescription());

            return new ResponseEntity<>(this.mediator.dispatch(safeCommand), HttpStatus.OK);
        }catch (ResponseStatusException e){
            log.error("{}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<DeleteToDoResponse> deleteTodoTask(@RequestBody @Valid DeleteToDoCommand command){
        try {
            DeleteToDoCommand safeCommand = new DeleteToDoCommand();
            log.info(SENDING_COMMAND, command.getClass().getName(), command);

            PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
            String safeId = policy.sanitize(command.getId());

            safeCommand.setId(safeId);

            return new ResponseEntity<>(this.mediator.dispatch(safeCommand), HttpStatus.CREATED);
        }catch (ResponseStatusException e){
            log.error("{}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
