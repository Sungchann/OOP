package Activity1Package;

public class Package {
    private int weightInOunces;
    private char shippingMethod; 
    private float shippingCost; 
    
    //Explicit Constructor
    Package(){
        
    }
    
    //Implicit Constructor (Has agruments)
    Package(int weightInOunces, char shippingMethod){
        this.weightInOunces = weightInOunces;
        Character.toUpperCase(shippingMethod);
        if (shippingMethod != 'A' && shippingMethod != 'T' && shippingMethod != 'M'){
            System.out.println("Shipping Method is not recognize!");
            System.out.println("Initializing the Shipping method to air");
            this.shippingMethod = 'A';
            calculateCost();
        }else{
            this.shippingMethod = shippingMethod;
            calculateCost();
        }
    }
    
    public float getShippingCost(){
        return this.shippingCost;
    }
    
    public void additionalShippingCost(float additionalCost){
        this.shippingCost += additionalCost; 
    }
    
    public void calculateCost(){
        switch(this.shippingMethod){
            case 'A':{
                if (this.weightInOunces > 0 && this.weightInOunces <= 8){
                    this.shippingCost = 90.00f;
                }
                else if (this.weightInOunces >= 9 && this.weightInOunces <= 16){
                    this.shippingCost = 135.00f;
                }
                else{
                    this.shippingCost =  202.50f;
                }
                break;
            }
            case 'T':{
                if (this.weightInOunces > 0 && this.weightInOunces <= 8){
                    this.shippingCost =  67.50f;
                }
                else if (this.weightInOunces >= 9 && this.weightInOunces <= 16){
                    this.shippingCost =  105.75f;
                }
                else{
                    this.shippingCost =  146.25f;
                }
                break;
            }
            case 'M':{
                if (this.weightInOunces > 0 && this.weightInOunces <= 8){
                    this.shippingCost =  22.50f;
                }
                else if (this.weightInOunces >= 9 && this.weightInOunces <= 16){
                    this.shippingCost =  67.50f;
                }
                else{
                    this.shippingCost =  96.75f;
                }
                break;
            }
        }
    }
    
    @Override
    public String toString() {
        return "Package{" + "weightInOunces= " + weightInOunces + ", shippingMethod= " + shippingMethod + ", shippingCost= " + shippingCost + '}';
    }
    
}
