package com.example.latihan.crud.service.master;

import com.example.latihan.crud.entities.master.ProductEntity;
import com.example.latihan.crud.repositories.master.ProductRepositories;
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
        productEntity.setDeleted(false);
        return productRepositories.save(productEntity) ;
    }

    @Override
    public List<ProductEntity> getAllProduct() throws Exception {
        return productRepositories.findAll();
    }

    @Override
    public List<ProductEntity> getAllProductStatusFalse() throws Exception {

        return productRepositories.findAllByDeletedFalseOrderByKodeBarangAsc();
    }

    @Override
    public ProductEntity getById(Long id) throws Exception {
        Optional<ProductEntity> productEntityOptional = productRepositories.findById(id);
        return productEntityOptional.get();
    }

    @Override
    public boolean deleteProduct(Long id) throws Exception {
        ProductEntity productEntity = productRepositories.findById(id).get();
        productEntity.setDeleted(true);
        productRepositories.save(productEntity);
        return true;
    }

}
