package com.example.latihan.crud.service.master;

import com.example.latihan.crud.entities.master.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    ProductEntity addProduct(ProductEntity productEntity) throws Exception;
    List<ProductEntity> getAllProduct() throws Exception;
    List<ProductEntity> getAllProductStatusFalse() throws Exception;
    ProductEntity getById(Long id) throws Exception;
    boolean deleteProduct(Long id) throws Exception;

}
