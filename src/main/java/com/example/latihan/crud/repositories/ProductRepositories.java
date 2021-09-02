package com.example.latihan.crud.repositories;

import com.example.latihan.crud.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositories extends JpaRepository<ProductEntity, Integer> {
}
