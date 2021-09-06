package com.example.latihan.crud.service.master;

import com.example.latihan.crud.entities.master.CustomerEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    CustomerEntity addCustomer(CustomerEntity productEntity) throws Exception;
    List<CustomerEntity> getAllCustomer() throws Exception;
    CustomerEntity getById(Long id) throws Exception;

    boolean deleteCustomer(Long id) throws Exception;

    List<CustomerEntity> getAllProductStatusFalse();

    CustomerEntity findByName(String customerName);
}
