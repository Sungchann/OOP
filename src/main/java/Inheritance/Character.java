/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inheritance;

/**
 *
 * @author JAMES
 */
public class Character {
    private int health;
    private String name;
    private static int count = 0; 
   
    Character(){
       
    }
   
    Character(int health, String name){
        this.health = health;
        this.name = name;
        count++;
    }
   
    public void eats(){
        System.out.println("The " + this.name + " is eating.");
    }
   
    private void talks(){
        System.out.println("The " + this.name + " is talking.");
    }
   
    public String getName(){
        return this.name;
    }
    
    public void getNumOfCharacters(){
        System.out.println("Characters = " + count);
    }
    
    private void getCurrentLevel(){
        System.out.println("Here");
    }
}
