package com.iit.spendanalyzer.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iit.spendanalyzer.controller.model.CategoryCount;
import com.iit.spendanalyzer.persistence.model.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    List<TransactionEntity> findTransactionEntitiesByCategoryOrderByDateDesc(String argCategory);

    @Query("SELECT new com.iit.spendanalyzer.controller.model.CategoryCount(T.category, COUNT(T.category)) FROM TransactionEntity AS T GROUP BY T.category")
    List<CategoryCount> countTotalTransactonsByCategory();

}
