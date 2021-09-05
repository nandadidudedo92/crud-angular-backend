package com.example.latihan.crud.service.identity;

import com.example.latihan.crud.entities.identity.RoleEntity;
import com.example.latihan.crud.entities.identity.UserEntity;
import com.example.latihan.crud.wrappers.UserWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    RoleEntity addRole(RoleEntity roleEntity) throws Exception;
    List<RoleEntity> getAllRole() throws Exception;
    RoleEntity getById(Long id) throws Exception;

}
