package com.example.latihan.crud.controllers;

import com.example.latihan.crud.entities.master.ProductEntity;
import com.example.latihan.crud.service.ProductService;
import com.example.latihan.crud.util.response.CommonResponse;
import com.example.latihan.crud.util.response.CommonResponseGenerator;
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
    ProductService productService;

    @Autowired
    CommonResponseGenerator comgen;

    @PostMapping(value = "add")
    CommonResponse<ProductEntity> addProduct(@RequestBody ProductEntity productEntity) throws Exception{

        try {
            ProductEntity product = productService.addProduct(productEntity);
            return comgen.successResponse(product, "Success Add Product");

        } catch ( Exception e) {
            logger.error(e.getMessage());
            return  comgen.failedResponse("Cek Apakah kode barang ada yang sama");
        }

    }

    @GetMapping(value = "list")
    CommonResponse<List<ProductEntity>> getAllProduct() {

        try {
            List<ProductEntity> productEntityList = productService.getAllProduct();
            return comgen.successResponse(productEntityList, "Success get All Product");

        } catch (Exception e) {
            logger.error(e.getMessage());
            return comgen.failedResponse(e.getMessage());
        }

    }

    @GetMapping(value = "id")
    CommonResponse<ProductEntity> getProductById(@RequestParam Long id) {
        try {
            ProductEntity productEntityList = productService.getById(id);
            return comgen.successResponse(productEntityList, "Success get Product By Id "+id);

        } catch (Exception e) {
            logger.error(e.getMessage());
            return comgen.failedResponse(e.getMessage());
        }
    }


}
