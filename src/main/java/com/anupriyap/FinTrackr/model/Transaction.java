package com.anupriyap.FinTrackr.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "transactions")
public class Transaction {

    @Id
    private String id;

    private double amount;

    private TransactionType type; // INCOME / EXPENSE

    private String category; // SALES / MARKETING / etc

    private LocalDate date;

    private String notes;
}
