package com.anupriyap.FinTrackr.controller;

import com.anupriyap.FinTrackr.model.Transaction;
import com.anupriyap.FinTrackr.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import com.anupriyap.FinTrackr.model.TransactionType;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // "create transaction record"
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Transaction createTransactionRecord(@RequestBody Transaction transaction) {
        return transactionService.createTransactionRecord(transaction);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
    public List<Transaction> getTransactions(
            @RequestParam(required = false) TransactionType type,
            @RequestParam(required = false) String category
    ) {
        return transactionService.getTransactions(type, category);
    }

    @GetMapping("/income")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
    public double getTotalIncome() {
        return transactionService.getTotalIncome();
    }

    @GetMapping("/expense")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
    public double getTotalExpense() {
        return transactionService.getTotalExpense();
    }

    @GetMapping("/balance")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
    public double getNetBalance() {
        return transactionService.getNetBalance();
    }

    @GetMapping("/category-breakdown")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    public Map<String, Double> getCategoryBreakdown() {
        return transactionService.getCategoryBreakdown();
    }

    @GetMapping("/trends")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    public Map<LocalDate, Double> getDailyTrends() {
        return transactionService.getDailyTrends();
    }

    @GetMapping("/paginated")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST'0)")
    public Page<Transaction> getTransactionsPaginated(Pageable pageable) {
        return transactionService.getTransactionsWithPagination(pageable);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Transaction updateTransaction(
            @PathVariable String id,
            @RequestBody Transaction transaction
    ) {
        return transactionService.updateTransaction(id, transaction);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteTransaction(@PathVariable String id) {
        transactionService.deleteTransaction(id);
        return "Transaction deleted successfully";
    }
}