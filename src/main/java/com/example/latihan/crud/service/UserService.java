package com.example.latihan.crud.service;

import com.example.latihan.crud.entities.identity.UserEntity;
import com.example.latihan.crud.entities.master.ProductEntity;
import com.example.latihan.crud.wrappers.UserWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserEntity addUser(UserWrapper userWrapper) throws Exception;
    List<UserEntity> getAllUser() throws Exception;
    UserEntity getById(Long id) throws Exception;

}
