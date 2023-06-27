package cm.cmd;

import cm.cmd.model.BankAccount;
import cm.cmd.model.CurrentAccount;
import cm.cmd.model.SavingAccount;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectReader;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App2 {

    public static void main(String[] args) throws JsonProcessingException {

        BankAccount[] accounts = new BankAccount[4];

        accounts[0] = new CurrentAccount(3000, "CAD", 1500);
        accounts[1] = new CurrentAccount(3000, "CAD", 1300);
        accounts[2] = new SavingAccount(6000, "XAF", 35);
        accounts[3] = new SavingAccount(1000, "YAN", 70);

        for(BankAccount account:accounts){
            System.out.println(account.toString());
        }


        System.out.println("===========================\n ===================");


        for(BankAccount account:accounts){
            System.out.println(toJson(account));
        }


        System.out.println("Exploitatin du polymorphisme \n===========================\n ===================");
        for(BankAccount acc:accounts){
            if(acc instanceof CurrentAccount){
                System.out.println(((CurrentAccount)acc).getType());
            } else if (acc instanceof SavingAccount) {
                System.out.println(((SavingAccount)acc).getType());
            }

        }



    }
        public static String toJson(Object o) throws JsonProcessingException {
            ObjectMapper objectMapper = new ObjectMapper();

            //si je veux juste sur une ligne sans indentation comme celui du bas
            //return objectMapper.writeValueAsString(o);

            //Avec indentation
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        }



}
