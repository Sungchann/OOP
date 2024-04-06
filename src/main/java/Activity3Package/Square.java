/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Activity3Package;

/**
 *
 * @author JAMES
 */
public class Square extends Shape{
    private float side;
    
    Square(){
        
    }
    
    Square(float side){
        this.side = side;
    }
    
    public float getArea(){
        return this.side*this.side;
    }
    
    public float getPerimeter(){
        return this.side*4; 
    }
    
    public void display(){
        System.out.println("Square where side = " + this.side);
    }
}
