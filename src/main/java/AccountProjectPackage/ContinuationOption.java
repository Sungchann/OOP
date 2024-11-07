/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccountProjectPackage;

import java.util.Scanner;

/**
 *
 * @author JAMES
 */
public class ContinuationOption {
    static int options(){
        Scanner getOption = new Scanner(System.in);
        int usersOption = 0;
        do{
            try{
                System.out.print("[1]Retry \n[2]Go to main menu \n[3]Exit \nSelect option: ");
                usersOption = getOption.nextInt();
                if (usersOption == 1){
                    return 1;
                }
                else if (usersOption == 2){
                    return 2;
                }
                else if (usersOption == 3){
                    return 3;
                }
                else{
                    System.out.println("Kindly enter [1-3].");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input. Kindly enter integers");
            }
            catch(Exception e){
                getOption.nextLine();
                System.out.println("Invalid input. Kindly enter integers");
            }
        }while(usersOption == 0);
        return -1; 
    }
}
