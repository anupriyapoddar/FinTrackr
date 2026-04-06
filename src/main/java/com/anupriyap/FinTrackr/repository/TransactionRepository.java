package com.anupriyap.FinTrackr.repository;

import com.anupriyap.FinTrackr.model.Transaction;
import com.anupriyap.FinTrackr.model.TransactionType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

    List<Transaction> findByType(TransactionType type);

    List<Transaction> findByCategory(String category);

    List<Transaction> findByTypeAndCategory(TransactionType type, String category);
}























