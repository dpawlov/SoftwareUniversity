package com.example.pathfiender.model.entity;

import com.example.pathfiender.model.entity.enums.RoleNameEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    private RoleNameEnum role;

    public Role() {
    }

    @Enumerated(EnumType.STRING)
    public RoleNameEnum getRole() {
        return role;
    }

    public void setRole(RoleNameEnum name) {
        this.role = name;
    }
}
