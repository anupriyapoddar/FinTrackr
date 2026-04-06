package com.anupriyap.FinTrackr.service;

import com.anupriyap.FinTrackr.model.Transaction;
import com.anupriyap.FinTrackr.model.TransactionType;
import com.anupriyap.FinTrackr.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.HashMap;
import java.util.Map;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // 👉 "create transaction record"
    public Transaction createTransactionRecord(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // 👉 GET transactions with filtering
    public List<Transaction> getTransactions(TransactionType type, String category) {

        if (type != null && category != null) {
            return transactionRepository.findByTypeAndCategory(type, category);
        }
        else if (type != null) {
            return transactionRepository.findByType(type);
        }
        else if (category != null) {
            return transactionRepository.findByCategory(category);
        }
        else {
            return transactionRepository.findAll();
        }
    }

    public double getTotalIncome() {
        return transactionRepository.findByType(TransactionType.INCOME)
                .stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double getTotalExpense() {
        return transactionRepository.findByType(TransactionType.EXPENSE)
                .stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }


    public double getNetBalance() {
        return getTotalIncome() - getTotalExpense();
    }


    public Map<String, Double> getCategoryBreakdown() {

        List<Transaction> transactions = transactionRepository.findAll();

        Map<String, Double> result = new HashMap<>();

        for (Transaction t : transactions) {
            String category = t.getCategory();
            double amount = t.getAmount();

            result.put(category, result.getOrDefault(category, 0.0) + amount);
        }

        return result;
    }

    public Map<LocalDate, Double> getDailyTrends() {

        List<Transaction> transactions = transactionRepository.findAll();

        Map<LocalDate, Double> result = new HashMap<>();

        for (Transaction t : transactions) {

            LocalDate date = t.getDate();
            double amount = t.getAmount();

            // expense → negative
            if (t.getType() == TransactionType.EXPENSE) {
                amount = -amount;
            }

            result.put(date, result.getOrDefault(date, 0.0) + amount);
        }

        return result;
    }

    public Page<Transaction> getTransactionsWithPagination(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }

    public Transaction updateTransaction(String id, Transaction updated) {

        Transaction existing = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        existing.setAmount(updated.getAmount());
        existing.setType(updated.getType());
        existing.setCategory(updated.getCategory());
        existing.setDate(updated.getDate());
        existing.setNotes(updated.getNotes());

        return transactionRepository.save(existing);
    }

    public void deleteTransaction(String id) {

        if (!transactionRepository.existsById(id)) {
            throw new RuntimeException("Transaction not found");
        }

        transactionRepository.deleteById(id);
    }

}





































































































