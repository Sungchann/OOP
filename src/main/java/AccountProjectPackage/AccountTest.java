// ------------------------------------------------------------------------
// OWNER: JAMES QUIJANO
// PROJECT INFO:
//      PUROSE: MIDTERM PROJECT / DEFENSE
//      TYPE OF PROJECT: ACCOUNT
// EXPECTED CLASSES:
//      [1]: JAVA ARRAYLIST
//      [2]: JAVA EXCEPTIONS (BUILT IN AND CUSTOMIZED EXCEPTIONS)
//              [a] CUSTOMIZED EXCEPTIONS
//                  -> SAW THE NEED THAT THERE SHOULD BE SPECIFIED EXCEPTIONS
//      [3]: REGEX (REGULAR EXPRESION)
//              -> USED FOR CREATING A STRING PATTERN.
//              -> FOR SEARCH PATTERN PURPOSES
//              -> IMPORTED MATCHER AND PATTERN CLASSES
//              ->
//      [4]: 
// ------------------------------------------------------------------------
package AccountProjectPackage;

import AccountProjectPackage.CustomedExceptionsAndTheirValidator.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class AccountTest {
    public static void main (String args[]){
        Scanner getInput = new Scanner(System.in);
        int index =0;
        
        //OBJECTS 
        ArrayList<Account> accountList = new ArrayList<>(); //[1]Dynamic Array of Accounts
        CheckInputValidity validator = new CheckInputValidity(); //[2]Object for checking input validity
        
        //Option
        int usersOption = 0;
        int continuationKey = 0; 
       
        do{
            try{
                System.out.println("\n------------------------------------------------------------------------");
                System.out.println("ACCOUNT PROJECT");
                System.out.print("[1]Create an account \n[2]Open an account \n[3]Exit \nChoose an option: ");
                usersOption = getInput.nextInt();
                getInput.nextLine();
                System.out.println("------------------------------------------------------------------------\n");
                switch(usersOption){
                    case 1:{
                        createAnAccount(accountList, validator, getInput, continuationKey);
                        break;
                    }
                    case 2:{
                        if (accountList.size() == 0){
                            System.out.println("There's no account yet.");
                        }else{
                            openingAnAccount(accountList, validator, getInput, continuationKey);
                        }
                        break;
                    }
                    case 3:{
                        System.out.println("EXIT! Thanks!");
                        break;
                    }
                    default:{
                        System.out.println("Kindly enter [1-3].");
                        break;
                    }
                }
            }catch(InputMismatchException e){
                System.out.println("Kindly enter interger only!");
                getInput.nextLine();
            }
        }while(usersOption != 3 && continuationKey != 3);
       
    }

// CREATING ACCOUNT METHOD
    static void createAnAccount(ArrayList<Account> accountList, CheckInputValidity validator, Scanner getInput, int continuationKey){
        //variables for obtaining data
        String getUsername = null, firstName =null, lastName=null, getPassword =null, checkPassword=null;
        
        //variables for checking entered data validity
        boolean checkUsersnameVadility =false, isFirstNameValid=false, isLastNameValid =false, isPasswordStrong=false; //EXCPETION PURPOSES
        
        int consentToCreateAccount = 0;
        int index = 0;
        
        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("SET USERNAME FOR ACCOUNT");
        do{ //creating an account
            try{
                System.out.print("Enter account username: ");
                getUsername = getInput.nextLine();
                validator.checkEnteredDataVadility(getUsername);
                validator.checkUsernameVadility(getUsername);
                validator.checkUsernameAvailability(getUsername, accountList);
                checkUsersnameVadility = true;
            }
            catch(EnteredWithNoCharacterException e){
                System.out.println("Null detected! Kindly characters.");
                continuationKey = ContinuationOption.options();
            }
            catch(SpaceException e){
                System.out.println("Username must be one word!");
                continuationKey = ContinuationOption.options();
            }
            catch(UsernameExistException e){
                System.out.println("Username already exist!");
                continuationKey = ContinuationOption.options();
            }
        }while(checkUsersnameVadility != true && continuationKey != 2 && continuationKey != 3);
        System.out.println("------------------------------------------------------------------------\n");
        
       
        if(continuationKey != 2 && continuationKey != 3){
            System.out.println("\n------------------------------------------------------------------------");
            System.out.println("NAME REGISTRATION FOR ACCOUNT");
            do{ //obtaining full name 
                try{
                    if(isFirstNameValid == false){
                        System.out.print("Enter first name: ");
                        firstName = getInput.nextLine();
                        validator.checkEnteredDataVadility(firstName);
                        validator.checkNameValidity(firstName);
                        isFirstNameValid = true;
                    }
                    if (isFirstNameValid == true && isLastNameValid == false){
                        System.out.print("Enter last name: ");
                        lastName = getInput.nextLine();
                        validator.checkEnteredDataVadility(lastName);
                        validator.checkNameValidity(lastName);
                        isLastNameValid = true;

                    }
                }
                catch(EnteredWithNoCharacterException e){
                    System.out.println("Null detected! Kindly characters.");
                    continuationKey = ContinuationOption.options();
                }
                catch(NameGotNumericValueException e){
                    System.out.println("Kindly input letters. Numerical values are not acceptable!");
                    continuationKey = ContinuationOption.options();
                }
                catch(NameGotSpecialCharacterException e){
                    System.out.println("Kindly input letters. Special Characters are not acceptable!");
                    continuationKey = ContinuationOption.options();
                }
                catch(Exception e){
                    System.out.println("Invalid input. Kindly");
                    continuationKey = ContinuationOption.options();
                }
            }while(isLastNameValid != true && continuationKey != 2 && continuationKey != 3);
            System.out.println("------------------------------------------------------------------------\n");
        }
        
     
        //setting password for account
        if(continuationKey != 2 && continuationKey != 3){
            System.out.println("\n------------------------------------------------------------------------");
            System.out.println("SET PASSWORD FOR ACCOUNT");
            do{
                try{
                    System.out.println("Note Password should contain: Numbers, Capital, Lowecase and Special Characters!");
                    System.out.print("Input password: ");
                    getPassword = getInput.nextLine();
                    validator.checkPasswordStrongness(getPassword);
                    do{
                        System.out.print("Re-enter password: ");
                        checkPassword = getInput.nextLine();
                        if (getPassword.equals(checkPassword)){
                            isPasswordStrong = true;
                        }
                        else{
                            System.out.println("Password not matched!");
                            continuationKey = ContinuationOption.options();
                        }
                    }while(isPasswordStrong != true && continuationKey != 2 && continuationKey != 3);
                    
                }
                catch(PasswordNotStrongException e){
                    System.out.println("Password not strong!");
                    continuationKey = ContinuationOption.options();
                }
                catch(Exception e){
                    System.out.println("Password invalid!");
                    continuationKey = ContinuationOption.options();
                }
            }while(isPasswordStrong != true && continuationKey != 2 && continuationKey != 3); 
            System.out.println("------------------------------------------------------------------------\n");
        }       
        
        //if conditions are correct then create account with their respective given data
        if (checkUsersnameVadility == true && isFirstNameValid == true && isLastNameValid == true && isPasswordStrong == true){
            System.out.println("\n------------------------------------------------------------------------");
            Account newAccount = new Account();
            accountList.add(newAccount);
            index = accountList.size();

            accountList.get(index-1).setUsername(getUsername);
            accountList.get(index-1).setFirstName(firstName);
            accountList.get(index-1).setLastName(lastName);
            accountList.get(index-1).setPassword(getPassword);
            accountList.get(index-1).generateID(index);
            
            System.out.println("ACCOUNT REGISTERED");
            System.out.println("Name: " + accountList.get(index-1).getFirstName() + " " + accountList.get(index-1).getLastName());
            System.out.println("Username: " + accountList.get(index-1).getUsername());
            System.out.println("Account ID: " + accountList.get(index-1).getID());
            System.out.println("Current Balance: " + accountList.get(index-1).getBalance());
            System.out.println("------------------------------------------------------------------------\n");
        }
    }
// OPENING AN ACCOUNT METHOD
    static void openingAnAccount(ArrayList<Account> accountList, CheckInputValidity validator, Scanner getInput, int continuationKey){
        int doesAccountExistAt = -1; 
        boolean isPasswordCorrect = false; 
        String getName="", getPassword="";
        
        System.out.println("\n------------------------------------------------------------------------");
        do{
            try{
                if (doesAccountExistAt == -1){
                    System.out.print("Enter username: ");
                    getName = getInput.nextLine();
                    validator.checkUsernameVadility(getName);
                    doesAccountExistAt = accountList.get(0).findAccountUsername(getName, accountList);

                    if (doesAccountExistAt == -1){
                        System.out.println("Username does not exist");
                        continuationKey = ContinuationOption.options();
                    }
                }
            }catch(SpaceException e){
                 System.out.println("Username must be one word!");
                continuationKey = ContinuationOption.options();
             }
        }while(doesAccountExistAt == -1 && continuationKey != 2 && continuationKey != 3);
        System.out.println("------------------------------------------------------------------------\n");
        
        if (continuationKey != 2 && continuationKey != 3){
            System.out.println("\n------------------------------------------------------------------------");
            do{
                if (isPasswordCorrect == false && doesAccountExistAt != -1){
                    System.out.print("Enter password: ");
                    getPassword = getInput.nextLine();
                    isPasswordCorrect = checkPassword(getPassword, accountList, doesAccountExistAt);
                    if (isPasswordCorrect == false){
                        System.out.println("Invalid password!");
                        continuationKey = ContinuationOption.options();
                    }
                }
            }while(isPasswordCorrect == false && continuationKey != 2 && continuationKey != 3);
            System.out.println("------------------------------------------------------------------------\n");
            
            //ENTER ACCOUNT OPTION
            if (isPasswordCorrect == true && doesAccountExistAt != -1){
                AccountOptions.accountOperations(accountList, doesAccountExistAt, continuationKey);
            } 
        }
           
    }
    
    static boolean checkPassword(String password, ArrayList<Account> accountList, int index){
        boolean isPasswordCorrect;
        return isPasswordCorrect = accountList.get(index).checkPassword(password);
    }
    
}