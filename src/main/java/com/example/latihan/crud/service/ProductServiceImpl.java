package com.example.latihan.crud.service;

import com.example.latihan.crud.entities.master.ProductEntity;
import com.example.latihan.crud.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepositories productRepositories;

    @Override
    public ProductEntity addProduct(ProductEntity productEntity) {
        return productRepositories.save(productEntity) ;
    }

    @Override
    public List<ProductEntity> getAllProduct() throws Exception {
        return productRepositories.findAll();
    }

    @Override
    public ProductEntity getById(Long id) throws Exception {
        Optional<ProductEntity> productEntityOptional = productRepositories.findById(id);
        return productEntityOptional.get();
    }

}
