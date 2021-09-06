package com.example.latihan.crud.service.transaction;

import com.example.latihan.crud.wrappers.AddTransactionWrapper;
import com.example.latihan.crud.wrappers.TransactionWrapper;
import com.example.latihan.crud.wrappers.TransactionDetailWrappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    TransactionWrapper addNewTransaction(AddTransactionWrapper transactionWrapper) throws Exception;

    List<TransactionDetailWrappers> getTopOnehundred();
}
