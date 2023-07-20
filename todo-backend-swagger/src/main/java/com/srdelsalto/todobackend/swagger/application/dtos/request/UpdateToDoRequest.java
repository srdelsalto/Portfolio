package com.srdelsalto.todobackend.swagger.application.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateToDoRequest {
    private String id;
    private String title;
    private String description;
}
