package com.example.latihan.crud.service.identity;

import com.example.latihan.crud.entities.identity.RoleEntity;
import com.example.latihan.crud.entities.identity.UserEntity;
import com.example.latihan.crud.entities.identity.UserProfileEntity;
import com.example.latihan.crud.repositories.identity.RoleRepositories;
import com.example.latihan.crud.repositories.identity.UserProfileRepositories;
import com.example.latihan.crud.repositories.identity.UserRepositories;
import com.example.latihan.crud.wrappers.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepositories userRepositories;

    @Autowired
    RoleRepositories roleRepositories;

    @Autowired
    UserProfileRepositories userProfileRepositories;

    @Transactional
    @Override
    public UserEntity addUser(UserWrapper userWrapper) throws Exception {

        UserEntity userEntity = new UserEntity();
        UserProfileEntity userProfileEntity = new UserProfileEntity();
        Optional<RoleEntity> roleEntity = roleRepositories.findById(userWrapper.getRoleId());
        if(userWrapper.getId() != null) {
            Optional<UserEntity> userEntityOptional = userRepositories.findById(userWrapper.getId());
            Optional<UserProfileEntity> userProfileEntityOptional = userProfileRepositories.findById(userEntityOptional.get().getUserProfile().getId());
            userEntity = userEntityOptional.get();
            userProfileEntity = userProfileEntityOptional.get();
        }
        userProfileEntity.setFullName(userWrapper.getFullName());
        userProfileEntity.setEmail(userWrapper.getEmail());
        userProfileRepositories.save(userProfileEntity);
        userEntity.setUsername(userWrapper.getUsername());
        userEntity.setPassword(userWrapper.getPassword());
        userEntity.setUserProfile(userProfileEntity);
        userEntity.setRole(roleEntity.get());
        userEntity.setDeleted(false);
        userEntity.setActive(true);
        return userRepositories.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUser() throws Exception {
        return userRepositories.findAll();
    }

    @Override
    public UserEntity getById(Long id) throws Exception {
        Optional<UserEntity> userEntityOptional = userRepositories.findById(id);
        return userEntityOptional.get();
    }



}
