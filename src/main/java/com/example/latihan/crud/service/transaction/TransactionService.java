package com.example.latihan.crud.service.transaction;

import com.example.latihan.crud.wrappers.AddTransactionWrapper;
import com.example.latihan.crud.wrappers.TransactionDetailWrapper;
import com.example.latihan.crud.wrappers.TransactionWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    TransactionDetailWrapper addNewTransaction(AddTransactionWrapper transactionWrapper) throws Exception;

    List<TransactionWrapper> getTopOnehundred();
}
