package com.srdelsalto.todobackend.swagger.infrastructure.repositories.jpa;

import com.srdelsalto.todobackend.swagger.infrastructure.models.ToDoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoJPARepository extends JpaRepository<ToDoModel, String> {
}
