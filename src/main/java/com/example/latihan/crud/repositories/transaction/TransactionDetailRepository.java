package com.example.latihan.crud.repositories.transaction;

import com.example.latihan.crud.entities.transaction.TransactionDetailEntity;
import com.example.latihan.crud.entities.transaction.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetailEntity, Long> {
}
