package com.iit.spendanalyzer.persistence.model;

import java.time.ZonedDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Id;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="TRANSACTION")
@Data
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String description;


    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    @CreationTimestamp
    private ZonedDateTime date;

}
