package com.example.latihan.crud.service.transaction;

import com.example.latihan.crud.entities.transaction.TransactionDetailEntity;
import com.example.latihan.crud.entities.transaction.TransactionEntity;
import com.example.latihan.crud.repositories.transaction.TransactionDetailRepository;
import com.example.latihan.crud.repositories.transaction.TransactionRepository;
import com.example.latihan.crud.util.CommonUtil;
import com.example.latihan.crud.wrappers.TransactionDetailWrapper;
import com.example.latihan.crud.wrappers.TransactionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionDetailRepository transactionDetailRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Transactional
    @Override
    public TransactionDetailWrapper addNewTransaction(List<TransactionWrapper> transactionWrapper) throws Exception {

        int total = 0;
        String transactionCode = CommonUtil.generateTransactionCode();

        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setTransationCode(transactionCode);

        List<TransactionDetailEntity> transactionDetailEntityList = new ArrayList<>();
        for (TransactionWrapper trans : transactionWrapper) {
            total = total + trans.getSubTotal();
            TransactionDetailEntity transactionDetailEntity = toTransactionDetailEntity(trans);
            transactionDetailEntityList.add(transactionDetailEntity);
        }

        transactionEntity.setTotalTransaction(total);
        transactionRepository.save(transactionEntity);
        transactionDetailEntityList.listIterator().forEachRemaining(transactionDetailEntity -> transactionDetailEntity.setTransactionEntity(transactionEntity));
        transactionDetailEntityList.listIterator().forEachRemaining(transactionDetailEntity -> transactionDetailEntity.setTransactionCode(transactionCode));


        transactionDetailRepository.saveAll(transactionDetailEntityList);

        System.out.println(total);

        return null;
    }


    private TransactionDetailEntity toTransactionDetailEntity(TransactionWrapper transactionWrapper){
        TransactionDetailEntity transactionDetailEntity = new TransactionDetailEntity();
        transactionDetailEntity.setNamaBarang(transactionWrapper.getNamaBarang());
        transactionDetailEntity.setKodeBarang(transactionWrapper.getKodeBarang());
        transactionDetailEntity.setQty(transactionWrapper.getQty());
        transactionDetailEntity.setSubTotal(transactionWrapper.getSubTotal());
        return transactionDetailEntity;
    }
}
