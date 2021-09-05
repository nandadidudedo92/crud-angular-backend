package com.example.latihan.crud.service.identity;

import com.example.latihan.crud.entities.identity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    UserEntity doLogin(UserEntity userEntity) throws Exception;

    String getJWTToken(String userName);
}
