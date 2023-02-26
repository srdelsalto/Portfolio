package com.srdelsalto.todobackend.swagger.infrastructure.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "todo")
@Accessors(chain = true)
@Getter
@Setter
public class ToDoModel {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "createdAt")
    private Date createdAt;

    @PrePersist
    public void prePersist() {
        this.status = false;
        this.createdAt = new Date(System.currentTimeMillis());
    }
}
