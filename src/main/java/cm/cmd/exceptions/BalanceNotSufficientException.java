package cm.cmd.exceptions;

public class BalanceNotSufficientException extends Throwable {
    public BalanceNotSufficientException(String message) {
       super(message);
    }
}
