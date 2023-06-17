package dao;

import domain.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {
    private List<Transaction> transactions;

    public TransactionRepository() {
        this.transactions = new ArrayList<>();

        // Sample data for testing
        transactions.add(new Transaction("user1", 100.0));
        transactions.add(new Transaction("user2", 200.0));
        transactions.add(new Transaction("user1", 150.0));
        transactions.add(new Transaction("user3", 50.0));
    }

    public void saveTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactions;
    }
}
