package onchoysakul.badin.exercises;

import java.rmi.registry.Registry;

class Rectangle{
    private double width, height;
    //constructor 
    public Rectangle(){
        width = 5;
        height = 8;
    }
    //constructor parameter
    public Rectangle(double w,double h){
        width = w;
        height = h;
    }
    //method
    public void doubleWidthHeight(){
        width = width *2;
        height = height *2;
    }

    public void print(){
        System.out.println("Rectangle width: " + width + ", Height: " + height);
    }
}

public class findRectangle {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.print();
        r1.doubleWidthHeight();
        System.out.println("After calling method doubleWidthHeight");
        r1.print();
    }
}
