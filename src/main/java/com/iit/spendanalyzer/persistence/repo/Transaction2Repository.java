package com.iit.spendanalyzer.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iit.spendanalyzer.controller.model.CategoryCount;
import com.iit.spendanalyzer.persistence.model.Transaction2Entity;

public interface Transaction2Repository extends JpaRepository<Transaction2Entity, Long> {

    List<Transaction2Entity> findTransaction2EntitiesByCategoryOrderByDateDesc(String argCategory);

    @Query("SELECT new com.iit.spendanalyzer.controller.model.CategoryCount(T.category, COUNT(T.category)) FROM Transaction2Entity AS T GROUP BY T.category")
    List<CategoryCount> countTotalTransactonsByCategory();

}
