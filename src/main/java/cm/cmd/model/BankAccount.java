package cm.cmd.model;
import cm.cmd.model.AccountStatus;

import java.util.Objects;
import java.util.UUID;

public abstract class BankAccount extends Object{

    private String accoundId;
    private double balance;
    private String currency;
    private AccountStatus status;
    public BankAccount(){
        this.accoundId= UUID.randomUUID().toString();
        this.status=AccountStatus.CREATED;
    }

    public BankAccount( double balance, String currency){
        this();
        this.balance = balance;
        this.currency = currency;
    }

    public String getAccoundId() {
        return accoundId;
    }

    public void setAccoundId(String accoundId) {
        this.accoundId = accoundId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "BankAccount{" +
                "accoundId='" + accoundId + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", status=" + status +
                '}';
    }

    public abstract String getType();

    public final void print(){
        System.out.println("=============== BANK ==============");
        // Une méthode déclarée de type final ne peut pas être redefinie
        // Par une sous classe.
    }
}
