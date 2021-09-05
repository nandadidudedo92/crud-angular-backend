package com.example.latihan.crud.controllers.identity;

import com.example.latihan.crud.entities.identity.UserEntity;
import com.example.latihan.crud.service.identity.UserService;
import com.example.latihan.crud.util.response.CommonResponse;
import com.example.latihan.crud.util.response.CommonResponseGenerator;
import com.example.latihan.crud.wrappers.UserWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    CommonResponseGenerator comgen;

    @PostMapping(value = "add")
    CommonResponse<UserEntity> addUser(@RequestBody UserWrapper userWrapper) throws Exception{

        try {
            UserEntity user = userService.addUser(userWrapper);
            return comgen.successResponse(user, "Success Add User");

        } catch ( Exception e) {
            logger.error(e.getMessage());
            return  comgen.failedResponse("Internal Server Error");
        }

    }

    @GetMapping(value = "list")
    CommonResponse<List<UserEntity>> getAllUser() {

        try {
            List<UserEntity> userEntityList = userService.getAllUser();
            return comgen.successResponse(userEntityList, "Success get All User");

        } catch (Exception e) {
            logger.error(e.getMessage());
            return comgen.failedResponse(e.getMessage());
        }

    }

    @GetMapping(value = "id")
    CommonResponse<UserEntity> getUserById(@RequestParam Long id) {
        try {
            UserEntity userEntityList = userService.getById(id);
            return comgen.successResponse(userEntityList, "Success get User By Id "+id);

        } catch (Exception e) {
            logger.error(e.getMessage());
            return comgen.failedResponse(e.getMessage());
        }
    }


}
