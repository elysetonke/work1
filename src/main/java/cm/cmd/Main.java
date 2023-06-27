package cm.cmd;

import cm.cmd.model.BankAccount;
import cm.cmd.model.CurrentAccount;
import cm.cmd.model.SavingAccount;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        BankAccount account1;
        account1 = new CurrentAccount(3000,"YAN",2500);
        printAccount(account1);

        BankAccount account2;
        account2 = new SavingAccount(2000,"CAD",70);
        printAccount(account2);

    }

    public static void printAccount(BankAccount account){

        System.out.println("\n");
        System.out.println("ID :"+account.getAccoundId());
        System.out.println("Status :"+account.getStatus());
        System.out.println("Balance :"+account.getBalance());
        System.out.println("Currency :"+account.getCurrency());
        System.out.println("Tostring :"+account.toString());
        System.out.println("Hascode :"+account.hashCode());
        System.out.println("Equals :"+account.equals(account));
        System.out.println("Account Direct :"+account);

        System.out.println("********************************************");
    }




}