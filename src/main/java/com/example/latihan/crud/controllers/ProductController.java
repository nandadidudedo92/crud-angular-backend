package com.example.latihan.crud.controllers;

import com.example.latihan.crud.entities.ProductEntity;
import com.example.latihan.crud.repositories.ProductRepositories;
import com.example.latihan.crud.util.CommonResponse;
import com.example.latihan.crud.util.CommonResponseGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "product")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductRepositories productRepositories;

    @Autowired
    CommonResponseGenerator comgen;

    @PostMapping(value = "add")
    CommonResponse<ProductEntity> addProduct(@RequestBody ProductEntity productEntity) throws Exception{

        try {
            ProductEntity product = productRepositories.save(productEntity);
            return comgen.successResponse(product, "Success Add Product");

        } catch ( Exception e) {
            logger.error(e.getMessage());
            return  comgen.failedResponse(e.getMessage());
        }

    }

    @GetMapping(value = "list")
    CommonResponse<List<ProductEntity>> getAllProduct() {

        try {
            List<ProductEntity> productEntityList = productRepositories.findAll();
            return comgen.successResponse(productEntityList, "Success get All Product");

        } catch (Exception e) {
            logger.error(e.getMessage());
            return comgen.failedResponse(e.getMessage());
        }

    }


}
