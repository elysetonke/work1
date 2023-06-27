package cm.cmd.model;

public class SavingAccount extends BankAccount{

    private double interestRate;

    public SavingAccount() {
        super();
    }

    public SavingAccount(double balance, String currency, double interestRate) {
        super(balance, currency);
        this.interestRate = interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "interestRate=" + interestRate + super.toString() +
                '}';
    }

    @Override
    public String getType() {
        return "SAVING_ACCOUNT";
    }

}
