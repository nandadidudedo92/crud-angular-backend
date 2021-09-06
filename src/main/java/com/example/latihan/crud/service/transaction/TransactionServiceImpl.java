package com.example.latihan.crud.service.transaction;

import com.example.latihan.crud.entities.master.ProductEntity;
import com.example.latihan.crud.entities.transaction.TransactionDetailEntity;
import com.example.latihan.crud.entities.transaction.TransactionEntity;
import com.example.latihan.crud.repositories.master.ProductRepositories;
import com.example.latihan.crud.repositories.transaction.TransactionDetailRepository;
import com.example.latihan.crud.repositories.transaction.TransactionRepository;
import com.example.latihan.crud.service.master.CustomerService;
import com.example.latihan.crud.util.CommonUtil;
import com.example.latihan.crud.wrappers.AddTransactionWrapper;
import com.example.latihan.crud.wrappers.TransactionWrapper;
import com.example.latihan.crud.wrappers.TransactionDetailWrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionDetailRepository transactionDetailRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ProductRepositories productRepositories;

    @Autowired
    CustomerService customerService;

    @Transactional
    @Override
    public TransactionWrapper addNewTransaction(AddTransactionWrapper transactionWrapper) throws Exception {

        int total = 0;
        String transactionCode = CommonUtil.generateTransactionCode(transactionRepository.count());

        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setTransationCode(transactionCode);
        transactionEntity.setCustomerEntity(customerService.findByName(transactionWrapper.getCustomerName()));

        List<TransactionDetailEntity> transactionDetailEntityList = new ArrayList<>();
        for (TransactionDetailWrappers trans : transactionWrapper.getTransactionWrapperList()) {
            total = total + trans.getSubTotal();
            TransactionDetailEntity transactionDetailEntity = toTransactionDetailEntity(trans);
            transactionDetailEntityList.add(transactionDetailEntity);
        }
        transactionEntity.setTotalTransaction(total);
        transactionRepository.save(transactionEntity);
        transactionDetailEntityList.listIterator().forEachRemaining(transactionDetailEntity -> transactionDetailEntity.setTransactionEntity(transactionEntity));
        transactionDetailEntityList.listIterator().forEachRemaining(transactionDetailEntity -> transactionDetailEntity.setTransactionCode(transactionCode));
        transactionDetailRepository.saveAll(transactionDetailEntityList);
        reduceStock(transactionDetailEntityList);
        return generateWrapper(total, transactionWrapper.getTransactionWrapperList(), transactionCode);
    }

    private TransactionWrapper generateWrapper(int total, List<TransactionDetailWrappers> transactionDetailWrappersList, String transactionCode) {
        TransactionWrapper transactionWrapper = new TransactionWrapper();
        transactionWrapper.setTotal(total);
        transactionWrapper.setTransactionWrapperList(transactionDetailWrappersList);
        transactionWrapper.setTransactionCode(transactionCode);

        return  transactionWrapper;
    }


    @Transactional
    public void reduceStock(List<TransactionDetailEntity> transactionDetailEntityList) {

        for (TransactionDetailEntity transactionDetailEntity:
        transactionDetailEntityList) {

            ProductEntity productEntity = productRepositories.findByKodeBarang(Integer.toString(transactionDetailEntity.getKodeBarang()));

            productEntity.setJumlah(productEntity.getJumlah()-transactionDetailEntity.getQty());

            productRepositories.save(productEntity);

        }

    }

    @Override
    public List<TransactionDetailWrappers> getTopOnehundred() {

        List<TransactionDetailWrappers> transactionDetailWrappersList = new ArrayList<>();
        List<TransactionDetailEntity> transactionDetailEntityList = transactionDetailRepository.findTop10ByOrderByNamaBarangAsc();
        for (TransactionDetailEntity transactionDetailEntity: transactionDetailEntityList) {
            transactionDetailWrappersList.add(toWrapper(transactionDetailEntity));
        }

        return transactionDetailWrappersList;
    }

    private TransactionDetailWrappers toWrapper(TransactionDetailEntity transactionDetailEntity) {
        TransactionDetailWrappers transactionDetailWrappers = new TransactionDetailWrappers();
        transactionDetailWrappers.setTransactionCode(transactionDetailEntity.getTransactionCode());
        transactionDetailWrappers.setKodeBarang(transactionDetailEntity.getKodeBarang());
        transactionDetailWrappers.setQty(transactionDetailEntity.getQty());
        transactionDetailWrappers.setSubTotal(transactionDetailEntity.getSubTotal());
        transactionDetailWrappers.setNamaBarang(transactionDetailEntity.getNamaBarang());
        return transactionDetailWrappers;

    }


    private TransactionDetailEntity toTransactionDetailEntity(TransactionDetailWrappers transactionDetailWrappers){
        TransactionDetailEntity transactionDetailEntity = new TransactionDetailEntity();
        transactionDetailEntity.setNamaBarang(transactionDetailWrappers.getNamaBarang());
        transactionDetailEntity.setKodeBarang(transactionDetailWrappers.getKodeBarang());
        transactionDetailEntity.setQty(transactionDetailWrappers.getQty());
        transactionDetailEntity.setSubTotal(transactionDetailWrappers.getSubTotal());
        return transactionDetailEntity;
    }
}
