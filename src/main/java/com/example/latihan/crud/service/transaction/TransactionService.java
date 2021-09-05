package com.example.latihan.crud.service.transaction;

import com.example.latihan.crud.wrappers.TransactionDetailWrapper;
import com.example.latihan.crud.wrappers.TransactionWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    TransactionDetailWrapper addNewTransaction(List<TransactionWrapper> transactionWrapper) throws Exception;

    List<TransactionWrapper> getTopOnehundred();
}
