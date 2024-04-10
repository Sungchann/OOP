package AccountProjectPackage;

import java.util.Scanner;
import java.util.ArrayList;

public class AccountTest {
    public static void main (String args[]){
        Scanner getInput = new Scanner(System.in);
        ArrayList<Account> accountList = new ArrayList<>();
        int usersOption;
        String getName;
        int getID, pinValidCounter=0, getPin =0, isPinValid, index = 0;
        int getAccountID, doesAccountExist = -1, depositMon;
       
        do{
            System.out.println("----ACCOUNT PROJECT-----");
            System.out.print("[1]Create an account \n[2]Open an account \n[3]Exit \nChoose an option: ");
            usersOption = getInput.nextInt();
            getInput.nextLine();
            switch(usersOption){
                case 1:{
                    accountList.add(new Account());
                    index = accountList.size();
                    
                    //SETTING ACCOUNT FOR ACCCOUNT
                    System.out.println("Account Registration");
                    System.out.print("Set account name: ");
                    getName = getInput.nextLine();
                    
                    //SETTING 4 DIGIT PIN FOR ACCCOUNT
                    System.out.println("Set account PIN\n");
                    do{
                        try{
                            System.out.print("Input digit :");
                            getPin = getInput.nextInt();
                            accountList.get(index-1).setPin(getPin, pinValidCounter);
                        }
                        catch(Exception e){
                            System.out.println("SAMOKE");
                        }
                    }while(pinValidCounter != 4);
                    System.out.print("Set 4 digit pin");
                    for (int x=0; x<4; x++){
                        System.out.print("Input digit " + (x+1) + " : ");
                        getPin = getInput.nextInt();
                    }
                    accountList.get(index-1).setName(getName);
                    accountList.get(index-1).generateID();
                    isPinValid = accountList.get(index-1).validatePin(getPin);
                    System.out.println(isPinValid);
                    System.out.println(accountList.get(index-1).toString());
                    
                    break;
                }
                case 2:{
                    if (index == 0){
                        System.out.println("There's no account yet.");
                    }else{
                        System.out.println("Enter account ID: ");
                        getAccountID = getInput.nextInt();
                        for(int x=0 ; x<accountList.size(); x++){
                            doesAccountExist = accountList.get(x).findAccount(getAccountID);
                            if (doesAccountExist == 1){
                                break;
                            }
                        }
                        if (doesAccountExist == 1){
                            accountOptions(accountList, index-1);
                        }
                        else{
                            System.out.println("Account does not exist.");
                        }
                       
                    }
                    break;
                }
                case 3:{
                    break;
                }
            }
        }while(usersOption != 3);
       
    }
   
    //
    static void accountOptions(ArrayList<Account> account, int accountIndex){
       Scanner getInput = new Scanner(System.in);
       int usersOption = 0, getAmount;
       
       do{
           System.out.println("Account Operatios");
           System.out.println("[1]Check Balance \n[2]Deposit Amount \n[3]Transfer Money \n[4]Withdraw \n[5]Exit");
           System.out.print("Enter Option: ");
           usersOption = getInput.nextInt();
           
           switch(usersOption){
               case 1:{ 
                   System.out.print("Current Balance: " + account.get(0).getBalance());
                   break;
               }
               case 2:{
                    System.out.print("Enter amount to deposit: ");
                    getAmount = getInput.nextInt();
                    account.get(0).depositAmount(getAmount);
                    System.out.println("Current Balance: " + account.get(0).getBalance());
                    break;
               }
               case 3:{
                    if(account.size() > 1){
                        
                    }
                    else{
                        System.out.println("There's no other account to be transfered");
                    }
               }
               case 4:{
                    
               }
               default:{
                   if (usersOption != 5){
                       System.out.println("Invalid Input!");
                   }
                   break;
               }
           }
       }while(usersOption != 5);
   
    }

}