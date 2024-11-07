/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccountProjectPackage;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author JAMES
 */
public class CustomedExceptionsAndTheirValidator {
    
    //CREATING CLASSES -> A CUSTOMED EXCEPTIONS
    
    public static class EnteredWithNoCharacterException extends Exception{}
    
    public static class SpaceException extends Exception{}
    
    public static class UsernameExistException extends Exception{}
    
    public static class NameGotNumericValueException extends Exception{}
    
    public static class NameGotSpecialCharacterException extends Exception{}
    
    public static class PasswordNotStrongException extends Exception{}   
    
    public static class NegativeAmountDepositException extends Exception{}
    
    public static class GetAmountExceedsToCurrentBalanceException extends Exception{}
    
    public static class DepositAmountZeroException extends Exception{}
    
    //CHECKING THE INPUT VALIDITY WITH THEIR SPECIFIED EXCEPTIONS 
    public static class CheckInputValidity{
        
        public void checkEnteredDataVadility(String name) throws EnteredWithNoCharacterException{
            if (name.isEmpty() == true){
                throw new EnteredWithNoCharacterException();
            }
        }
        
        public void checkUsernameAvailability(String username, ArrayList<Account> accountList) throws UsernameExistException{
            if (accountList.size() != 0){
                int doesUsernameAvailable = accountList.get(0).findAccountUsername(username, accountList);
                if (doesUsernameAvailable != -1){
                    throw new UsernameExistException();
                }
            }
        }
        public void checkUsernameVadility(String username)throws SpaceException{
            Pattern isUsernameHaveSpace = Pattern.compile("[\\s]");
            Matcher checkUserNameSpace = isUsernameHaveSpace.matcher(username);

            if (checkUserNameSpace.find() == true){
                throw new SpaceException();
            }
        } 

        public void checkNameValidity (String name) throws NameGotNumericValueException, NameGotSpecialCharacterException{
            Pattern isNameHaveNumericalValue = Pattern.compile("[0-9]");
            Pattern isNameHaveSpecialCharacter = Pattern.compile("[^0-9a-zA-Z\\s]");
            Matcher checkNameIfHaveNum = isNameHaveNumericalValue.matcher(name);
            Matcher checkNameIfHaveSpecialChar = isNameHaveSpecialCharacter.matcher(name);

            if (checkNameIfHaveNum.find() == true){
                throw new NameGotNumericValueException();
            }

            if (checkNameIfHaveSpecialChar.find() == true){
                throw new NameGotSpecialCharacterException();
            }
        }

        public void checkPasswordStrongness (String password) throws PasswordNotStrongException{
            Pattern isPasswordHaveSmallLetters = Pattern.compile("[a-z]");
            Pattern isPasswordHaveCapitalLetters = Pattern.compile("[A-Z]");
            Pattern isPasswordHaveNumericalValues = Pattern.compile("[0-9]");
            Pattern isPasswordHaveSpecialChar = Pattern.compile("[^0-9a-zA-Z]");
            Matcher checkPassSmallLetter = isPasswordHaveSmallLetters.matcher(password);
            Matcher checkPassCapLetter = isPasswordHaveCapitalLetters.matcher(password);
            Matcher checkPassNum = isPasswordHaveNumericalValues.matcher(password);
            Matcher checkPassSpecialChar = isPasswordHaveSpecialChar.matcher(password);

            if(checkPassSmallLetter.find() == false || checkPassCapLetter.find() == false || checkPassNum.find() == false ||  checkPassSpecialChar.find() == false){
                throw new PasswordNotStrongException();
            }
        }

        public void checkEnteredAmountIfNotNegative(float amount) throws NegativeAmountDepositException{
            if (amount < 0){
                throw new NegativeAmountDepositException();
             }
        }    
        
        public void checkGetAmountIfExceedsToTheCurrentBalance(float toGetAmount, float currentBalance) throws GetAmountExceedsToCurrentBalanceException{
            if (toGetAmount > currentBalance){
                throw new GetAmountExceedsToCurrentBalanceException();
            }
        }
        
        public void checkAmountIfZero(float amount) throws DepositAmountZeroException{
            if (amount == 0){
                throw new DepositAmountZeroException();
            }
        }
    }
}
