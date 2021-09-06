package com.example.latihan.crud.repositories.master;

import com.example.latihan.crud.entities.master.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepositories extends JpaRepository<CustomerEntity, Long> {
    List<CustomerEntity> findAllByDeletedFalse();
    CustomerEntity findOneByCustomerName(String customerName);
}
