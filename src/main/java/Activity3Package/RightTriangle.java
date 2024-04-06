/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Activity3Package;

/**
 *
 * @author JAMES
 */
public class RightTriangle extends Triangle{
    
    RightTriangle(){
        
    }
    RightTriangle(float base, float height){
       super(base, height);
    }
    
    public float getPerimeter(){
        return getBase() + getHeight() + (float)Math.hypot(getBase(), getHeight());
    }
}
