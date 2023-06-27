package cm.cmd;

import cm.cmd.Utils.DataTransformationUtils;
import cm.cmd.metier.BankAccountService;
import cm.cmd.metier.BankAccountServiceImpl;
import cm.cmd.model.BankAccount;
import com.fasterxml.jackson.core.JsonProcessingException;


public class App3 {

    public static void main(String[] args) throws JsonProcessingException {
        BankAccountService bankAccountService=new BankAccountServiceImpl();
        bankAccountService.addRandomData(20);
        for(BankAccount bankAccount:bankAccountService.getAllAccounts()){
           System.out.println(bankAccount.toString());

        }



        for(BankAccount acc:bankAccountService.getAllAccounts()){
            System.out.println(DataTransformationUtils.toJson(acc));

        }

        System.out.println("================\n=========== list des Saving Accounts");
        for(BankAccount acc: bankAccountService.getSavingAccounts()){
            System.out.println(DataTransformationUtils.toJson(acc));
        }




        System.out.println("================\n=========== list des CURRENT ACCOUNT");
        for(BankAccount acc: bankAccountService.getCurrentAccounts()){
            System.out.println(DataTransformationUtils.toJson(acc));
        }


        System.out.println("================\n=========== Total des balances");

        System.out.println("Total Balance: "+bankAccountService.getTotalBalance() );
    }

}
