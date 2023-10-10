package com.iit.spendanalyzer.controller.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Transaction {
        
        @NotNull
        private String category;
        
        @NotNull
        private String description;
        
        private double amount;
}
