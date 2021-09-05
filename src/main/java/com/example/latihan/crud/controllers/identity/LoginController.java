package com.example.latihan.crud.controllers.identity;

import com.example.latihan.crud.entities.identity.UserEntity;
import com.example.latihan.crud.service.identity.LoginService;
import com.example.latihan.crud.service.identity.UserService;
import com.example.latihan.crud.util.response.CommonResponse;
import com.example.latihan.crud.util.response.CommonResponseGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

    Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    CommonResponseGenerator comGen;

    @Autowired
    LoginService loginService;

    @PostMapping(value = "login")
    CommonResponse<UserEntity> doLogin(@RequestBody UserEntity user, HttpServletResponse response) {

        try {
            UserEntity userEntity = loginService.doLogin(user);
            String token = loginService.getJWTToken(user.getUsername());
            response.addHeader("Authorization", token);
            return comGen.successResponse(userEntity, "Login Success");
        } catch (Exception e){
            logger.info(e.getMessage());
            return comGen.failedResponse("Login Failed");
        }
    }

}
