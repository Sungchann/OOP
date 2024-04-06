/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inheritance;

/**
 *
 * @author JAMES
 */
public class test {
    public static void main (String args[]){
        Character character1 = new Dragon(12, "Draks", "LightFury");
        Object character2=  new Character(12, "James");
        Object character3=  new Dragon(12, "Draco", "Fire Dragon");
        Dragon dragon1 = new Dragon(12, "Draco", "NightFury");
        //Character boss1 = new Boss();
        //Dragon character2 = new Character(12, "Draks");

        dragon1.eats();
        dragon1.attacks();

        if (character2 instanceof Character){
            Character character = (Character) character2; 
            character.eats();
        }
        //System.out.println(character2.eats());
        character1.getNumOfCharacters();
    }

}
