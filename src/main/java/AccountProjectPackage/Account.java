/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccountProjectPackage;

/**
 *
 * @author JAMES
 */
public class Account {
    private String accountName; 
    private int accountID;
    private int balance;
    private int pin[] = new int[4]; //CREATING FOUR PIN 
    private static int count;
   
   
    // ------------------------------------------------------------------------
    // CREATING ACCOUNT
    // ------------------------------------------------------------------------
    
    Account(){
        this.balance = 0;
    }
   
    Account(String name, int accountID, int balance){
        this.accountName = name;
        this.balance = 0;
        this.accountID = accountID;
    }
   

    public void setName(String name){
        this.accountName = name;
    }
   
    public void generateID(){
        this.accountID = 100;
    }

    
    public int validatePin(int pin){
        int tempPin = pin; 
        int digitCount = 0; 
        do{
            tempPin /= 10; 
            digitCount++; 
            if(digitCount > 4){
                System.out.println("HEREEEE");
                return -1;
            }
            else if(digitCount < 4 && tempPin%10 == tempPin){
                System.out.println("HERE AY");
                return -1;
            }
        }while(tempPin%10 != tempPin);
        return 1;
    }
    
    public void setPin(int digit, int at){
   
    }
   
    // ------------------------------------------------------------------------
    //
    // ------------------------------------------------------------------------
    public int findAccount(int accountID){
        if (accountID == this.accountID)
            return 1;
        else{
            return -1;
        }
    }
    
    public int getBalance(){
        return this.balance;
    }
    
    public void depositAmount(int amount){
        this.balance += amount;
    }
    
    @Override
    public String toString() {
        return "Account Information \nAccountName = " + this.accountName + "\naccountID = " + this.accountID + "\nbalance = " + this.balance;
    }
    
    
}

