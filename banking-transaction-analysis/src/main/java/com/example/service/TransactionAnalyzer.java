package service;

import dao.TransactionRepository;
import domain.Transaction;
import domain.User;
import exception.SelfTransactionAnalysisException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import security.SecureTransactionAnalysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
package service;

import dao.TransactionRepository;
import domain.Transaction;
import domain.User;
import exception.SelfTransactionAnalysisException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import security.SecureTransactionAnalysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionAnalyzer implements UserDetailsService {

    private TransactionRepository transactionRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public TransactionAnalyzer(TransactionRepository transactionRepository, PasswordEncoder passwordEncoder) {
        this.transactionRepository = transactionRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            return new User("admin", passwordEncoder.encode("admin123"), "ROLE_ADMIN");
        } else if ("analyst".equals(username)) {
            return new User("analyst", passwordEncoder.encode("analyst123"), "ROLE_ANALYST");
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ANALYST')")
    @SecureTransactionAnalysis(excludeSelf = true, userId = "${user.id}")
    public List<Transaction>  analyzeTransactions(String userId) {
        List<Transaction> transactions = transactionRepository.getAllTransactions();

        for (Transaction transaction : transactions) {
            if (excludeSelfTransaction(transaction.getUserId(), userId)) {
                throw new SelfTransactionAnalysisException("Cannot analyze own transactions");
            }
        }
        return getAllSuspiciousTransactions();

    }

    private boolean excludeSelfTransaction(String transactionUserId, String userId) {
        return transactionUserId.equals(userId);
    }

    public List<Transaction> getAllSuspiciousTransactions() {
        // Implementation to retrieve all suspicious transactions based on time proximity
        List<Transaction> transactions = transactionRepository.getAllTransactions();
        markSuspiciousTransactions(transactions);

        return transactions;
    }

    private void markSuspiciousTransactions(List<Transaction> transactions) {
        // Logic to mark suspicious transactions based on specific conditions
        for (Transaction transaction : transactions) {
            // Example condition: Mark transactions with amount greater than 1000 as suspicious
            if (transaction.getAmount() > 1000) {
                transaction.setSuspicious(true);
            }
        }
    }

    private Map<String, Double> getTransactionsByUserId(String userId) {
        // Mocked transactions data
        Map<String, Double> transactions = new HashMap<>();
        if ("user123".equals(userId)) {
            transactions.put("tx1", 100.0);
            transactions.put("tx2", 200.0);
            transactions.put("tx3", 300.0);
        }
        return transactions;
    }
}
