/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inheritance;

/**
 *
 * @author JAMES
 */
public class Dragon extends Character{
    private String dragonType;
   
    Dragon(){
    }
   
    Dragon(int health, String name, String type){
        super(health, name);
        this.dragonType = type;
    }
   
    @Override
    public void eats(){
        super.eats();
        System.out.println("Eats human");
    }
   
    public void attacks(){
        System.out.println("The " + getName() + " is attacking.");
        breathesFire();
    }
   
    private void breathesFire(){
        System.out.println("The " + super.getName() + " breathes fire.");
    }
    
    static void tries(){
        System.out.println("HERE");
    }
    
    public void display(){
        System.out.println("LOL");
    }
}
