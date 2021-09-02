package com.example.latihan.crud.service;

import com.example.latihan.crud.entities.ProductEntity;

import java.util.List;

public interface ProductService {

    ProductEntity addProduct(ProductEntity productEntity) throws Exception;
    List<ProductEntity> getAllProduct() throws Exception;
    ProductEntity getById(Long id) throws Exception;

}
