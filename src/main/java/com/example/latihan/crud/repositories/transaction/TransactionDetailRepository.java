package com.example.latihan.crud.repositories.transaction;

import com.example.latihan.crud.entities.transaction.TransactionDetailEntity;
import com.example.latihan.crud.util.wrapper.ReportStockOutWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetailEntity, Long> {

    List<TransactionDetailEntity> findTop10ByOrderByNamaBarangAsc();

//    @Query("SELECT NEW com.example.latihan.crud.util.wrapper.ReportStockOutWrapper(s.kodeBarang, s.namaBarang, sum(s.qty) qty) FROM TransactionDetailEntity s where (s.kodeBarang between :startCode and :endCode) " +
//            "and (s.createdDate between :startDate and :endDate) group by s.kodeBarang, s.namaBarang")
//    List<TransactionDetailEntity> getStockOutReport(@Param("startCode") int startCode, @Param("endCode") int endCode,
//                                          @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT NEW com.example.latihan.crud.util.wrapper.ReportStockOutWrapper(s.kodeBarang, s.namaBarang, sum(s.qty), p) FROM TransactionDetailEntity s " +
            " inner join ProductEntity p on s.kodeBarang = p.kodeBarang where (s.kodeBarang between :startCode and :endCode) " +
            " and (s.createdDate between :startDate and :endDate) group by s.kodeBarang, s.namaBarang")
    List<ReportStockOutWrapper> getStockOutReport(@Param("startCode") int startCode, @Param("endCode") int endCode, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
