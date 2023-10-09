package com.iit.spendanalyzer.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iit.spendanalyzer.persistence.model.TransactionEntity;


public interface TransactionRepository extends JpaRepository<TransactionEntity, Long>{

    List<TransactionEntity> findTransactionEntitiesByCategoryOrderByDateDesc(String argCategory);
    
}
