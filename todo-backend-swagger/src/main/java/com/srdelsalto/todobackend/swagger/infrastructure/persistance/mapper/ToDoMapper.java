package com.srdelsalto.todobackend.swagger.infrastructure.persistance.mapper;

import com.srdelsalto.todobackend.swagger.domain.entities.ToDo;
import com.srdelsalto.todobackend.swagger.infrastructure.models.ToDoModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToDoMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "createdAt", target = "createdAt")
    ToDo toEntity(ToDoModel toDoModel);
    List<ToDo> toEntities(List<ToDoModel> toDoModels);
    @InheritInverseConfiguration
    ToDoModel toModel(ToDo todo);
}
