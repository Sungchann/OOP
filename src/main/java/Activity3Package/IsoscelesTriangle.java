/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Activity3Package;

/**
 *
 * @author JAMES
 */
public class IsoscelesTriangle extends Triangle{
    
    IsoscelesTriangle(){
        
    }
    IsoscelesTriangle(float base, float height){
       super(base, height);
    }
    
    @Override
    public float getPerimeter(){
        return 2 * (getBase()+getHeight());
    }
}
