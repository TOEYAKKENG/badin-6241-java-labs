package onchoysakul.badin.lab7;

import java.io.Serializable;

public abstract class MobileDevice  {
    protected String color;
    protected double price;
    protected String name;
    protected String brand;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public double getPrice(){
        return price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getBrand(){
        return brand;
    }
    //constructor
    public MobileDevice(String name, String brand, double price, String color){
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.color = color;
    }
    //constructor
    public MobileDevice(String name, String brand, double price){
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public abstract boolean isWatch();

}
