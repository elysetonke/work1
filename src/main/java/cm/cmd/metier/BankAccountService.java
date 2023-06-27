package cm.cmd.metier;

import cm.cmd.exceptions.AccountNotFoundException;
import cm.cmd.exceptions.BalanceNotSufficientException;
import cm.cmd.model.BankAccount;
import java.util.List;

public interface BankAccountService {
    // Quand je crée une interface je suis à la phase de conception
    // c'est donc toute l'importance de la couche métier ou business layer
    BankAccount addBankAccount(BankAccount account);
    List<BankAccount> getAllAccounts();
    BankAccount getAccountById(String id) throws AccountNotFoundException;
    void addRandomData(int size);
    void credit(String accountId,double mount) throws AccountNotFoundException;
    void debit(String accountId,double mount) throws AccountNotFoundException, BalanceNotSufficientException;
    void transfer(String accountSource,String accountDestination,double mount) throws AccountNotFoundException, BalanceNotSufficientException;

    List<BankAccount> getSavingAccounts();
    List<BankAccount> getCurrentAccounts();
    double getTotalBalance();

    //List<BankAccount> searchAccounts();

}
