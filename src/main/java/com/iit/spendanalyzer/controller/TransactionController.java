
package com.iit.spendanalyzer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iit.spendanalyzer.controller.model.CategoryCount;
import com.iit.spendanalyzer.controller.model.Transaction;
import com.iit.spendanalyzer.controller.model.Transaction2;
import com.iit.spendanalyzer.persistence.model.TransactionEntity;
import com.iit.spendanalyzer.persistence.model.Transaction2Entity;
import com.iit.spendanalyzer.persistence.repo.TransactionRepository;
import com.iit.spendanalyzer.persistence.repo.Transaction2Repository;

@Controller
public class TransactionController {

    private TransactionRepository transactionRepository;
    private Transaction2Repository transaction2Repository;

    public TransactionController(TransactionRepository argTransactionRepository,Transaction2Repository argTransaction2Repository) {
        this.transactionRepository = argTransactionRepository;
        this.transaction2Repository = argTransaction2Repository;
    }

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "index";
    }

    @GetMapping("/transactions")
    @ResponseBody
    public List<TransactionEntity> findAll(@RequestParam(name="category", defaultValue="all") String argCategory) {
       if("all".equals(argCategory))
        return transactionRepository.findAll();

        return transactionRepository.findTransactionEntitiesByCategoryOrderByDateDesc(argCategory);
    }

    @GetMapping("/transactions2")
    @ResponseBody
    public List<Transaction2Entity> findAll2(@RequestParam(name="category", defaultValue="all") String argCategory) {
       if("all".equals(argCategory))
        return transaction2Repository.findAll();

        return transaction2Repository.findTransaction2EntitiesByCategoryOrderByDateDesc(argCategory);
    }

    @GetMapping("/categories")
    @ResponseBody
    public List<CategoryCount> getTransactionCategories() {
        return transactionRepository.countTotalTransactonsByCategory();
    }


    @PostMapping("/transactions")
    @ResponseBody
    public TransactionEntity addTransaction(Transaction argTransaction) {
        TransactionEntity entity = new TransactionEntity();
        entity.setDescription(argTransaction.getDescription());
        entity.setCategory(argTransaction.getCategory());
        entity.setAmount(argTransaction.getAmount());
        return transactionRepository.saveAndFlush(entity);
    }

    @PostMapping("/transactions2")
    @ResponseBody
    public TransactionEntity addTransaction2(Transaction2 argTransaction) {
        TransactionEntity entity = new TransactionEntity();
        entity.setDescription(argTransaction.getDescription());
        entity.setCategory(argTransaction.getCategory());
        entity.setAmount(argTransaction.getAmount());
        return transactionRepository.saveAndFlush(entity);
    }
}
