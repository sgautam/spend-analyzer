package com.iit.spendanalyzer.controller.model;

import lombok.Data;

@Data
public class CategoryCount {
    private long count;
    private String category;

    public CategoryCount(String argCategory, long argCount){
        category=argCategory;
        count=argCount;
    }
}
