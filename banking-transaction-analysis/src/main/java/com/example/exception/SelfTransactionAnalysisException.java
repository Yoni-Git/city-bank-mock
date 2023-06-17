package exception;

public class SelfTransactionAnalysisException extends RuntimeException {
    public SelfTransactionAnalysisException(String message) {
        super(message);
    }
}
