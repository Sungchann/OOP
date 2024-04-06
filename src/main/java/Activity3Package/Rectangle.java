/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Activity3Package;

/**
 *
 * @author JAMES
 */
public class Rectangle extends Shape{
    private float width; 
    private float length; 
    
    Rectangle(){
        
    }
    
    Rectangle(float width, float length){
        this.width = width;
        this.length = length;
    }
    @Override
    public float getArea(){
        return this.width * this.length;
    }
    
    @Override
    public float getPerimeter(){
        return (this.width * 2) + (this.length*2);
    }
    
    public void display(){
        System.out.println("Rectangle where W = " + this.width + " and L = " + this.length);
    }
}
