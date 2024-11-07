/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccountProjectPackage;

import AccountProjectPackage.CustomedExceptionsAndTheirValidator.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author JAMES
 */
public class AccountOptions {
    static void accountOperations(ArrayList<Account> account, int accountIndex, int continuationKey){
       Scanner getInput = new Scanner(System.in);
       CheckInputValidity validator = new CheckInputValidity(); //[2]Object for checking input validity
       
       String getUsername="";
       int usersOptionForAccountOperation = 0, doesAccountExistAt =-1;
       float getAmount =0;
       boolean isOperationSuccessfull = false; 
       
       System.out.println("\n------------------------------------------------------------------------");
       do{
           try{
                System.out.println("Account Operatios");
                System.out.println("[1]Check Balance \n[2]Deposit Amount \n[3]Withdraw amount\n[4]Transfer amount \n[5]Display Info \n[6]Exit");
                System.out.print("Enter Option: ");
                usersOptionForAccountOperation = getInput.nextInt();

                switch(usersOptionForAccountOperation){
                    case 1:{ 
                        System.out.println("\n------------------------------------------------------------------------");
                        System.out.println("Current Balance: " + account.get(accountIndex).getBalance());
                        break;
                    }
                    
                    case 2:{
                        System.out.println("\n------------------------------------------------------------------------");
                        do{
                            try{
                                System.out.print("Enter amount to deposit: ");
                                getAmount = getInput.nextFloat();   
                                validator.checkEnteredAmountIfNotNegative(getAmount);
                                validator.checkAmountIfZero(getAmount);
                                
                                isOperationSuccessfull = true;
                                account.get(accountIndex).depositAmount(getAmount);
                                System.out.println("Amount successfully depositted!");
                                System.out.println("Current Balance: " + account.get(accountIndex).getBalance());
                            }catch(InputMismatchException e){
                                System.out.println("Kindly enter an amount value!");
                                continuationKey = ContinuationOption.options();
                            }catch(NegativeAmountDepositException e){
                                System.out.println("Amount should be positive!");
                                continuationKey = ContinuationOption.options();
                            }catch(DepositAmountZeroException e){
                                System.out.println("Amount should be greater than zero!");
                                continuationKey = ContinuationOption.options();
                            }
                         }while(isOperationSuccessfull == false && continuationKey != 2 && continuationKey != 3);
                        break;
                    }
                    
                    case 3:{
                        System.out.println("\n------------------------------------------------------------------------");
                        if(account.get(accountIndex).getBalance() > 0){
                            do{
                               try{
                                    System.out.print("Enter amount to withdraw: ");
                                    getAmount = getInput.nextFloat(); 
                                    isOperationSuccessfull = withdrawOrTransferAmount(account, accountIndex, continuationKey, getAmount);
                                    System.out.println(getAmount);
                                    if (isOperationSuccessfull == true){
                                        account.get(accountIndex).withdrawAmount(getAmount);
                                        System.out.println("Amount successfully withdrawn!");
                                        System.out.println("Current Balance: " + account.get(accountIndex).getBalance());
                                    }
                               }catch(InputMismatchException e){
                                    System.out.println("Kindly enter interger only!");
                                    getInput.nextLine();
                                    continuationKey = ContinuationOption.options();
                               }
                            }while(isOperationSuccessfull == false && continuationKey != 2 && continuationKey != 3);
                        }
                        else{
                            System.out.println("Unable to withdraw! Balance is empty");
                        }
                        break;
                    }
                    case 4:{
                        System.out.println("\n------------------------------------------------------------------------");
                        if(account.size() > 1 && account.get(accountIndex).getBalance() > 0){
                             do{
                                try{
                                    System.out.println("Enter username to transfer: ");
                                    getUsername = getInput.next();
                                    validator.checkUsernameVadility(getUsername);
                                    doesAccountExistAt = account.get(accountIndex).findAccountUsername(getUsername, account);
                                    if (doesAccountExistAt != -1 && account.get(accountIndex).getUsername().equals(getUsername) != true){
                                        do{
                                            try{
                                                System.out.print("Enter amount to transfer: ");
                                                getAmount = getInput.nextFloat(); 
                                                isOperationSuccessfull = withdrawOrTransferAmount(account, accountIndex, continuationKey, getAmount);
                                                if(isOperationSuccessfull == true){
                                                    account.get(accountIndex).transferAmount(getAmount, doesAccountExistAt, account);
                                                    System.out.println("Amount successfully transfered!");
                                                    System.out.println("Current Balance: " + account.get(accountIndex).getBalance());
                                                }
                                            }catch(InputMismatchException e){
                                                System.out.println("Kindly enter interger only!");
                                                getInput.nextLine();
                                                continuationKey = ContinuationOption.options();
                                            }
                                        }while(isOperationSuccessfull == false && continuationKey != 2 && continuationKey != 3);
                                    }
                                    else if (account.get(accountIndex).getUsername().equals(getUsername) == true){
                                        System.out.println("Cannot transfer to own account");
                                    }
                                    else{
                                        System.out.println("Username does not exist!");
                                        continuationKey = ContinuationOption.options();
                                    }
                                }catch(SpaceException e){
                                    System.out.println("Username must be one word!");
                                    continuationKey = ContinuationOption.options();
                                }
                             }while(isOperationSuccessfull == false && continuationKey != 2 && continuationKey != 3);
                        }
                        else if (account.get(accountIndex).getBalance() < 1){
                            System.out.println("Unable to transfer! Current balance is empty!");
                        }
                        else{
                            System.out.println("There's no other account to be transfered");
                        }
                        break;
                    }
                    case 5:{
                        System.out.println("\n------------------------------------------------------------------------");
                        System.out.println("ACCOUNT REGISTERED");
                        System.out.println("Name: " + account.get(accountIndex).getFirstName() +" "+ account.get(accountIndex).getLastName());
                        System.out.println("Username: " + account.get(accountIndex).getUsername());
                        System.out.println("Account ID: " + account.get(accountIndex).getID());
                        System.out.println("Current Balance: " + account.get(accountIndex).getBalance());
                        System.out.println("------------------------------------------------------------------------\n");
                        break;
                    }
                    case 6:{
                        break;
                    }
                    default:{
                        System.out.println("Kindly enter [1-6].");
                        break;
                    }
                }
            }catch(InputMismatchException e){
                System.out.println("Kindly enter interger only!");
                getInput.nextLine();
            }
       }while(usersOptionForAccountOperation != 6 && continuationKey != 3);
    }
    
    static boolean withdrawOrTransferAmount(ArrayList<Account> account, int accountIndex, int continuationKey, float getAmount){
        CheckInputValidity validator = new CheckInputValidity();
        
        try{
            validator.checkEnteredAmountIfNotNegative(getAmount);
            validator.checkGetAmountIfExceedsToTheCurrentBalance(getAmount, account.get(accountIndex).getBalance());
            validator.checkAmountIfZero(getAmount);
            return true;
        }
        catch(InputMismatchException e){
            System.out.println("Kindly enter an amount value!");
            continuationKey = ContinuationOption.options();
        }
        catch(NegativeAmountDepositException e){
            System.out.println("Amount should be positive!");
            continuationKey = ContinuationOption.options();
        }
        catch(GetAmountExceedsToCurrentBalanceException e){
            System.out.println("Amount to be withdrawn must be lesser than the current amount!");
            continuationKey = ContinuationOption.options();
        }catch(DepositAmountZeroException e){
            System.out.println("Amount should be greater than zero!");
            continuationKey = ContinuationOption.options();
        }
        return false; 
    }

}
