/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccountProjectPackage;

import java.util.ArrayList;

/**
 *
 * @author JAMES
 */
public class Account {
    private String username; 
    private String firstName;
    private String lastName;
    private int accountID;
    private float balance;
    private String password; 
   
   
    // ------------------------------------------------------------------------
    // CREATING ACCOUNT
    // ------------------------------------------------------------------------
    Account(){
        this.balance = 0;
    }
   

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void generateID(int x){
        this.accountID = 100 + x;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
   
    public int findAccount(String userName){
        if (this.username.equals(userName)){
            return 1;
        }
        else{
            return 0;
        }
    }
    public int findAccountUsername(String usersName, ArrayList<Account> accountList){
        int numberOfAccounts = accountList.size();
        int doesAccountExist; 
        for (int x=0; x<numberOfAccounts; x++){
            doesAccountExist = accountList.get(x).findAccount(usersName);
            if (doesAccountExist == 1){
                return x;
            }
        }
        return -1;
    }
    
    public boolean checkPassword(String password){
        if (this.password.equals(password)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getUsername(){
        return this.username;
    }
    public int getID(){
        return this.accountID;
    }
    
    public float getBalance(){
        return this.balance;
    }
    
    public void depositAmount(float amount){
        this.balance += amount;
    }
    
    public void withdrawAmount(float amount){
        this.balance -= amount;
    }
    
    public void transferAmount(float amount, int atIndexToBeTransferred, ArrayList<Account> accountList){
        this.balance -= amount;
        accountList.get(atIndexToBeTransferred).depositAmount(amount);
    }
    
    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", accountID=" + accountID + ", balance=" + balance + '}';
    }
 
}

