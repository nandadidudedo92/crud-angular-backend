package com.example.latihan.crud.controllers.master;

import com.example.latihan.crud.entities.master.CustomerEntity;
import com.example.latihan.crud.entities.master.ProductEntity;
import com.example.latihan.crud.service.master.CustomerService;
import com.example.latihan.crud.util.response.CommonResponse;
import com.example.latihan.crud.util.response.CommonResponseGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "customer")
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @Autowired
    CommonResponseGenerator comgen;

    @PostMapping(value = "add")
    CommonResponse<CustomerEntity> addCustomer(@RequestBody CustomerEntity customerEntity) throws Exception{

        try {
            CustomerEntity customer = customerService.addCustomer(customerEntity);
            return comgen.successResponse(customer, "Success Add Customer");

        } catch ( Exception e) {
            logger.error(e.getMessage());
            return  comgen.failedResponse(e.getMessage());
        }

    }

    @GetMapping(value = "list")
    CommonResponse<List<CustomerEntity>> getAllCustomer() {

        try {
            List<CustomerEntity> customerEntityList = customerService.getAllCustomer();
            return comgen.successResponse(customerEntityList, "Success get All Customer");

        } catch (Exception e) {
            logger.error(e.getMessage());
            return comgen.failedResponse(e.getMessage());
        }

    }

    @GetMapping(value = "list-param")
    CommonResponse<List<CustomerEntity>> getAllProductParam() {

        try {
            List<CustomerEntity> customerEntityList = customerService.getAllProductStatusFalse();
            return comgen.successResponse(customerEntityList, "Success get All Customer");

        } catch (Exception e) {
            logger.error(e.getMessage());
            return comgen.failedResponse(e.getMessage());
        }

    }

    @GetMapping(value = "id")
    CommonResponse<CustomerEntity> getCustomerById(@RequestParam Long id) {
        try {
            CustomerEntity customerEntityList = customerService.getById(id);
            return comgen.successResponse(customerEntityList, "Success get Customer By Id "+id);

        } catch (Exception e) {
            logger.error(e.getMessage());
            return comgen.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "delete")
    CommonResponse<Boolean> deleteCustomer(@RequestParam Long id) {
        try {
            boolean isDelete = customerService.deleteCustomer(id);
            return comgen.successResponse(isDelete, "Success Delete Data");

        } catch (Exception e) {
            logger.error(e.getMessage());
            return comgen.failedResponse("Failed Delete Data");
        }
    }

}
