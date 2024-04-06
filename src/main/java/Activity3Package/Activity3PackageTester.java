/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Activity3Package;

/**
 *
 * @author JAMES
 */
public class Activity3PackageTester {
    
    public static void main(String args[]){
        Square square = new Square(2);
        Rectangle rectangle = new Rectangle(2,4);
        RightTriangle rightTriangle = new RightTriangle(15, 8);
        IsoscelesTriangle isoscelesTriangle = new IsoscelesTriangle(15, 8);
    
        square.display();
        System.out.println("Area = " + square.getArea());
        System.out.println("Perimeter = " + square.getPerimeter());

        rectangle.display();
        System.out.println("Area = " + rectangle.getArea());
        System.out.println("Perimeter = " + rectangle.getPerimeter());

        System.out.println("Right Triangle ");
        rightTriangle.display();
        System.out.println("Area = " + rightTriangle.getArea());
        System.out.println("Perimeter = " + rightTriangle.getPerimeter());

        System.out.println("Isoceles Triangle ");
        isoscelesTriangle.display();
        System.out.println("Area = " + isoscelesTriangle.getArea());
        System.out.println("Perimeter = " + isoscelesTriangle.getPerimeter());
    }
    
}
