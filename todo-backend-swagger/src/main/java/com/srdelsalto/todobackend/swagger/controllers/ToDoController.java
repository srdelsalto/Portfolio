package com.srdelsalto.todobackend.swagger.controllers;

import com.srdelsalto.todobackend.swagger.application.command.create.CreateToDoCommand;
import com.srdelsalto.todobackend.swagger.application.dtos.responses.CreateToDoResponse;
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

@RestController
@RequestMapping("/todo")
@CrossOrigin("*")
@Slf4j
public class ToDoController {
    public static final String SENDING_COMMAND = "----- Sending command: {} {}";
    public static final String SENDING_QUERY = "------ Sending query: {} {}";

    @Autowired
    private Mediator mediator;
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<String> getAllTodosTask(){
//        try {
//            log.info(SENDING_COMMAND, com);
//        }catch (ResponseStatusException e){
//            log.error("{}", e);
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<CreateToDoResponse> createToDoTask(@Valid @RequestBody CreateToDoCommand command){
        try {
            CreateToDoCommand safeCommand = new CreateToDoCommand();
            log.info(SENDING_COMMAND, command.getClass().getName(), command);

            PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
            String safeParameterName = policy.sanitize(command.getName());
            safeCommand.setName(safeParameterName);

            return new ResponseEntity<>(this.mediator.dispatch(safeCommand), HttpStatus.CREATED);
        }catch (ResponseStatusException e){
            log.error("{}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
