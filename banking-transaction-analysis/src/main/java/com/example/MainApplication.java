import dao.TransactionRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import service.TransactionAnalyzer;

public class MainApplication {
    public static void main(String[] args) {
        TransactionRepository transactionRepository = new TransactionRepository();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        TransactionAnalyzer transactionAnalyzer = new TransactionAnalyzer(transactionRepository, passwordEncoder);

        // Example usage
        String userId = "user123";
        double totalAmount = transactionAnalyzer.analyzeTransactions(userId);
        System.out.println("Total amount spent by user " + userId + ": " + totalAmount);
    }
}
