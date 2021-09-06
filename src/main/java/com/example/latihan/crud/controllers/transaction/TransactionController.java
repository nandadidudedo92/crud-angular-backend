package com.example.latihan.crud.controllers.transaction;

import com.example.latihan.crud.controllers.master.ProductController;
import com.example.latihan.crud.service.transaction.TransactionService;
import com.example.latihan.crud.util.response.CommonResponse;
import com.example.latihan.crud.util.response.CommonResponseGenerator;
import com.example.latihan.crud.wrappers.TransactionDetailWrapper;
import com.example.latihan.crud.wrappers.TransactionWrapper;
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
    CommonResponse<List<TransactionWrapper>> newTransaction(@RequestBody List<TransactionWrapper> transactionWrapperList){
        try {
            TransactionDetailWrapper transactionDetailWrapper = transactionService.addNewTransaction(transactionWrapperList);
            return comGen.successResponse(transactionWrapperList, "Transaction Success");
        } catch (Exception e) {
            logger.info(e.getMessage());
            return comGen.failedResponse("Transaction Failed");
        }
    }

    @GetMapping(value = "list")
    CommonResponse<List<TransactionWrapper>> getTopTransactionDetail() {
        try {

            List<TransactionWrapper> transactionWrapperList = transactionService.getTopOnehundred();
            return comGen.successResponse(transactionWrapperList, "Success get top 100 transaction");
        } catch (Exception e) {
            logger.info(e.getMessage());
            return comGen.failedResponse("Gagal Mengambil Data");

        }

    }

}