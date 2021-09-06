package com.example.latihan.crud.service.master;

import com.example.latihan.crud.entities.master.CustomerEntity;
import com.example.latihan.crud.repositories.master.CustomerRepositories;
import com.example.latihan.crud.repositories.master.CustomerRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepositories customerRepositories;

    @Override
    public CustomerEntity addCustomer(CustomerEntity customerEntity) {
        customerEntity.setDeleted(false);
        return customerRepositories.save(customerEntity) ;
    }

    @Override
    public List<CustomerEntity> getAllCustomer() throws Exception {
        return customerRepositories.findAll();
    }

    @Override
    public CustomerEntity getById(Long id) throws Exception {
        Optional<CustomerEntity> customerEntityOptional = customerRepositories.findById(id);
        return customerEntityOptional.get();
    }

    @Override
    public boolean deleteCustomer(Long id) throws Exception {
        CustomerEntity customerEntity = customerRepositories.findById(id).get();
        customerEntity.setDeleted(true);
        customerRepositories.save(customerEntity);
        return true;
    }

    @Override
    public List<CustomerEntity> getAllProductStatusFalse() {
        return customerRepositories.findAllByDeletedFalse();
    }

    @Override
    public CustomerEntity findByName(String customerName) {
        return customerRepositories.findOneByCustomerName(customerName);
    }

}
