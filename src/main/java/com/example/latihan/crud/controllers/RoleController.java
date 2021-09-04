package com.example.latihan.crud.controllers;

import com.example.latihan.crud.entities.identity.RoleEntity;
import com.example.latihan.crud.service.RoleService;
import com.example.latihan.crud.util.response.CommonResponse;
import com.example.latihan.crud.util.response.CommonResponseGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "role")
public class RoleController {

    Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    RoleService roleService;

    @Autowired
    CommonResponseGenerator comgen;

    @PostMapping(value = "add")
    CommonResponse<RoleEntity> addRole(@RequestBody RoleEntity roleEntity) throws Exception{

        try {
            RoleEntity role = roleService.addRole(roleEntity);
            return comgen.successResponse(role, "Success Add Role");

        } catch ( Exception e) {
            logger.error(e.getMessage());
            return  comgen.failedResponse("Internal Server Error");
        }

    }

    @GetMapping(value = "list")
    CommonResponse<List<RoleEntity>> getAllRole() {

        try {
            List<RoleEntity> roleEntityList = roleService.getAllRole();
            return comgen.successResponse(roleEntityList, "Success get All Role");

        } catch (Exception e) {
            logger.error(e.getMessage());
            return comgen.failedResponse(e.getMessage());
        }

    }

    @GetMapping(value = "id")
    CommonResponse<RoleEntity> getRoleById(@RequestParam Long id) {
        try {
            RoleEntity roleEntityList = roleService.getById(id);
            return comgen.successResponse(roleEntityList, "Success get Role By Id "+id);

        } catch (Exception e) {
            logger.error(e.getMessage());
            return comgen.failedResponse(e.getMessage());
        }
    }


}
