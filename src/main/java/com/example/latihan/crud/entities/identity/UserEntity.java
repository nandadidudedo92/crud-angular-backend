package com.example.latihan.crud.entities.identity;

import com.example.latihan.crud.util.model.AuditableBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sys_user")
public class UserEntity extends AuditableBase {


    @Column(name = "username", length = 15)
    private String username;

    @Column(name = "password", length = 15)
    private String password;

    private boolean active;

    @Column(name = "role_id")
    private RoleEntity roleEntity;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }
}
