package com.example.latihan.crud.controllers.transaction;

import com.example.latihan.crud.service.transaction.TransactionService;
import com.example.latihan.crud.util.response.CommonResponse;
import com.example.latihan.crud.util.response.CommonResponseGenerator;
import com.example.latihan.crud.wrappers.AddTransactionWrapper;
import com.example.latihan.crud.wrappers.TransactionWrapper;
import com.example.latihan.crud.wrappers.TransactionDetailWrappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "transaction")
public class TransactionController {


    Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    TransactionService transactionService;

    @Autowired
    CommonResponseGenerator comGen;

    @PostMapping(value = "new")
    CommonResponse<List<TransactionDetailWrappers>> newTransaction(@RequestBody AddTransactionWrapper transactionWrapper){
        try {
            TransactionWrapper transactionDetailWrapper = transactionService.addNewTransaction(transactionWrapper);
            return comGen.successResponse(transactionWrapper.getTransactionWrapperList(), "Transaction Success");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return comGen.failedResponse("Transaction Failed");
        }
    }

    @GetMapping(value = "list")
    CommonResponse<List<TransactionDetailWrappers>> getTopTransactionDetail() {
        try {

            List<TransactionDetailWrappers> transactionDetailWrappersList = transactionService.getTopOnehundred();
            return comGen.successResponse(transactionDetailWrappersList, "Success get top 100 transaction");
        } catch (Exception e) {
            logger.info(e.getMessage());
            return comGen.failedResponse("Gagal Mengambil Data");

        }

    }

}
