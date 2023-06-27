package cm.cmd;

import cm.cmd.exceptions.AccountNotFoundException;
import cm.cmd.metier.BankAccountService;
import cm.cmd.metier.BankAccountServiceImpl;
import cm.cmd.model.BankAccount;
import cm.cmd.model.CurrentAccount;
import cm.cmd.model.SavingAccount;

import java.util.List;



public class Application {
    public static void main(String[] args) throws Exception {

        BankAccountService bankAccountService=new BankAccountServiceImpl();
        // j'Aurais pu faire comme ici
        //BankAccountServiceImpl bankAccountService1 = new BankAccountServiceImpl();

        bankAccountService.addBankAccount(new CurrentAccount(86000,"XAF",2000));
        bankAccountService.addBankAccount(new SavingAccount(35000,"XAF",3.5));

        BankAccount bankAccount3 = new SavingAccount(1500000,"XAF",3.2);
        bankAccount3.setAccoundId("CC3");
        bankAccountService.addBankAccount(bankAccount3);

        List<BankAccount> allAccounts =  bankAccountService.getAllAccounts();

        for (int i = 0; i < allAccounts.size();i++){
            System.out.println(allAccounts.get(i).toString());
        }

        System.out.println("\n ========= deuxieme méthode pour affichage");

        for(BankAccount bankAccount:allAccounts){
            System.out.println(bankAccount.toString());
        }

        System.out.println("\n ========= Troisieme méthode pour affichage avec streams");
        //allAccounts.forEach(System.out::println);


        System.out.println("\n ========= recherche d'un compte par son id");


        try {
            BankAccount accountById = bankAccountService.getAccountById("CC5");
            System.out.println(accountById.toString());
        }catch (AccountNotFoundException e){
            System.out.println(e.getMessage());
        }





        System.out.println("\n ========= Suite du programme");






    }
}
