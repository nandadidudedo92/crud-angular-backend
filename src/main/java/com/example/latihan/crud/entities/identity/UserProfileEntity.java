package com.example.latihan.crud.entities.identity;

import com.example.latihan.crud.util.model.AuditableBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sys_user_profile")
public class UserProfileEntity extends AuditableBase  {

    @Column(name = "full_name", length = 50)
    private String fullName;

    private String email;

    private RoleEntity role;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
