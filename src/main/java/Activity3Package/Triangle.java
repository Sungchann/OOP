/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Activity3Package;

/**
 *
 * @author JAMES
 */
public abstract class Triangle extends Shape {
    private float base;
    private float height; 
    
    Triangle(){
        
    }
    Triangle(float base, float height){
        this.base = base;
        this.height = height;
    }
    
    public float getBase(){
        return this.base; 
    }
    
    public float getHeight(){
        return this.height;
    }
    
    @Override
    public float getArea(){
        return (this.height * this.base)/2;
    }
     
    @Override
    public abstract float getPerimeter();
    
    public void display(){
        System.out.println("where B = " + this.base + " and H = " + this.height);
    }
}
