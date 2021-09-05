package com.example.latihan.crud.repositories.transaction;

import com.example.latihan.crud.entities.transaction.TransactionDetailEntity;
import com.example.latihan.crud.entities.transaction.TransactionEntity;
import com.example.latihan.crud.wrappers.TransactionWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetailEntity, Long> {

    List<TransactionDetailEntity> findTop10ByOrderByNamaBarangAsc();
}
