package com.iit.spendanalyzer.persistence.model;

import java.time.ZonedDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="TRANSACTION")
@Data
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String description;


    @Column(nullable = false)
    private double amount;

    @Column(nullable = false, name="CREATEDDATE")
    @CreationTimestamp
    @CreatedDate
    private ZonedDateTime date;

}
