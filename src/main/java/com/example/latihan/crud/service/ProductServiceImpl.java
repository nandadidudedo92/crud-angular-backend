package com.example.latihan.crud.service;

import com.example.latihan.crud.entities.ProductEntity;
import com.example.latihan.crud.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepositories productRepositories;

    @Override
    public ProductEntity addProduct(ProductEntity productEntity) throws Exception {
        return productRepositories.save(productEntity) ;
    }

    @Override
    public List<ProductEntity> getAllProduct() throws Exception {
        return productRepositories.findAll();
    }

    @Override
    public ProductEntity getById(Long id) throws Exception {
        Optional<ProductEntity> productEntityOptional = productRepositories.findById(id);
        return null;
    }
}
