package com.example.latihan.crud.service.identity;

import com.example.latihan.crud.entities.identity.RoleEntity;
import com.example.latihan.crud.repositories.identity.RoleRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepositories roleRepositories;

    @Override
    public RoleEntity addRole(RoleEntity roleEntity) throws Exception {
        return roleRepositories.save(roleEntity);
    }

    @Override
    public List<RoleEntity> getAllRole() throws Exception {
        return roleRepositories.findAll();
    }

    @Override
    public RoleEntity getById(Long id) throws Exception {
        Optional<RoleEntity> roleEntityOptional = roleRepositories.findById(id);
        return roleEntityOptional.get();
    }
}
