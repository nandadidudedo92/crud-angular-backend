package com.example.latihan.crud.entities.identity;

import com.example.latihan.crud.util.model.AuditableBase;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sys_role")
public class RoleEntity extends AuditableBase {

    private String roleCode;
    private String roleName;
}
