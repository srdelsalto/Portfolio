package com.srdelsalto.todobackend.swagger.domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ToDo {
    private String id;
    private String name;
    private Boolean status;
    private Date createdAt;
}
