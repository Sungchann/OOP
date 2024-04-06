/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Activity1Package;

/**
 *
 * @author JAMES
 */
public class InsuredPackage extends Package {
    
    //Implicit Constructor
    InsuredPackage(int weightInOunces, char shippingMethod){
        super(weightInOunces, shippingMethod);
        additionalCost();
    }
    
    public void additionalCost(){
        if(super.getShippingCost() >= 0 && super.getShippingCost() <= 45.00f){
            super.additionalShippingCost(110.25f);
        }
        else if(super.getShippingCost() >= 45.01f && super.getShippingCost() <= 135.00f){
            super.additionalShippingCost(177.75f);
        }
        else if (super.getShippingCost() >= 135.01){
            super.additionalShippingCost(245.75f);
        }
        else{
            super.additionalShippingCost(0);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }       
    
}
