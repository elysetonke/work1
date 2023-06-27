package cm.cmd.metier;

import cm.cmd.exceptions.AccountNotFoundException;
import cm.cmd.exceptions.BalanceNotSufficientException;
import cm.cmd.model.AccountStatus;
import cm.cmd.model.BankAccount;
import cm.cmd.model.CurrentAccount;
import cm.cmd.model.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankAccountServiceImpl implements BankAccountService{

   /* à partir de java 5 on a pu introduire la notion de collecition
    generique qui permet de définir le type d'objet à stocker.
    au fond je cherche une méthode de stockage j'ai choisie une liste*/
    private List<BankAccount> bankAccountList=new ArrayList<>();


    @Override
    public BankAccount addBankAccount(BankAccount account) {

        bankAccountList.add(account);
        return account;
    }

    @Override
    public List<BankAccount> getAllAccounts() {
        return bankAccountList;
    }

    @Override
    public BankAccount getAccountById(String id) throws AccountNotFoundException {


       //BankAccount bankAccount = bankAccountList.stream().filter(acc -> acc.getAccoundId().equals(id)).findFirst();
        for(BankAccount bankAccount:bankAccountList){
            if(bankAccount.getAccoundId().equals(id)){
                return bankAccount;
            }
        }
        //return null; je genere plutot une exeption;
        // il y'a deux type d'Exeption : surveillé et non surveillé
        //surveillé = signalé par le compilateur = Exception
        //non surveillé = non signalé par le compilateur = RunTimeException
        throw new AccountNotFoundException("BankAccount not found");
    }

    @Override
    public void addRandomData(int size) {
        AccountStatus[] values = AccountStatus.values();
        Random random = new Random();
        for(int i =0; i<size; i++) {
            BankAccount bankAccount;
            if (Math.random() > 0.5) {
                // expression ternaire(à trois opérandes)
                bankAccount= new CurrentAccount(Math.random() * 1000000,Math.random()>0.5?"XAF":"USD", Math.random() * 50000);
                bankAccount.setStatus(values[random.nextInt(values.length)]);
            } else {
                bankAccount= new SavingAccount(Math.random() * 1000000,Math.random()>0.5?"XAF":"USD", Math.random() * 50000);
                bankAccount.setStatus(values[random.nextInt(values.length)]);
            }
            bankAccountList.add(bankAccount);
        }

    }

    @Override
    public void credit(String accountId, double mount) throws AccountNotFoundException {

        BankAccount accountById = getAccountById(accountId);
        accountById.setBalance(accountById.getBalance()+mount);

    }

    @Override
    public void debit(String accountId, double mount) throws AccountNotFoundException,BalanceNotSufficientException {
        BankAccount accountById = getAccountById(accountId);

//        Ici il faut faire un test pour valider que le test ne rend pas le montant négatif

        if (mount>accountById.getBalance()) throw new BalanceNotSufficientException("Balance insuffisante");
        accountById.setBalance(accountById.getBalance()+mount);


    }

    @Override
    public void transfer(String accountSource, String accountDestination, double mount) throws AccountNotFoundException, BalanceNotSufficientException {

        debit(accountSource,mount);
        credit(accountDestination,mount);

    }

    @Override
    public List<BankAccount> getSavingAccounts() {
        List<BankAccount> result = new ArrayList<>();
        for(BankAccount acc:bankAccountList){
            if(acc instanceof SavingAccount){
                result.add(acc);
            }

        }
        return result;
    }

    @Override
    public List<BankAccount> getCurrentAccounts() {
        List<BankAccount> result = new ArrayList<>();
        for(BankAccount acc:bankAccountList){
            if(acc instanceof CurrentAccount){
                result.add(acc);
            }

        }
        return result;
    }

    @Override
    public double getTotalBalance() {

        double sum = 0;

        for(BankAccount acc:bankAccountList){
            sum =sum+acc.getBalance();
        }

        return sum;
    }
}
