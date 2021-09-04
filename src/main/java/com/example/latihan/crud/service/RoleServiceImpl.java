package com.example.latihan.crud.service;

import com.example.latihan.crud.entities.identity.RoleEntity;
import com.example.latihan.crud.entities.identity.UserEntity;
import com.example.latihan.crud.entities.identity.UserProfileEntity;
import com.example.latihan.crud.repositories.RoleRepositories;
import com.example.latihan.crud.repositories.UserProfileRepositories;
import com.example.latihan.crud.repositories.UserRepositories;
import com.example.latihan.crud.wrappers.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
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
