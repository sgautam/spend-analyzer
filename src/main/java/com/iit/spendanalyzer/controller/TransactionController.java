
package com.iit.spendanalyzer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iit.spendanalyzer.controller.model.Transaction;
import com.iit.spendanalyzer.persistence.model.TransactionEntity;
import com.iit.spendanalyzer.persistence.repo.TransactionRepository;

@Controller
public class TransactionController {

    private TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository argTransactionRepository) {
        this.transactionRepository = argTransactionRepository;
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
    public List<TransactionEntity> findAll() {
        return transactionRepository.findAll();
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
}
