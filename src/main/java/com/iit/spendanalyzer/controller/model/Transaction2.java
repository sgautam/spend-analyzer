package com.iit.spendanalyzer.controller.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Transaction2 {
        
        @NotNull
        private String category;
        
        @NotNull
        private String description;
        
        private double amount;
}
