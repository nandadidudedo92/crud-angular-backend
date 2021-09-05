package com.example.latihan.crud.repositories.master;

import com.example.latihan.crud.entities.master.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositories extends JpaRepository<ProductEntity, Long> {
}
