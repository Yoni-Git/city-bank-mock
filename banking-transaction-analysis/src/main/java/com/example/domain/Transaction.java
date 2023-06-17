package domain;

import java.time.LocalDateTime;
import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private double amount;
    private String userId;
    private LocalDateTime timestamp;
    private boolean isSuspicious;

    public Transaction(String id, double amount, String userId, LocalDateTime timestamp) {
        this.id = id;
        this.amount = amount;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isSuspicious() {
        return isSuspicious;
    }

    public void setSuspicious(boolean suspicious) {
        isSuspicious = suspicious;
    }
}
