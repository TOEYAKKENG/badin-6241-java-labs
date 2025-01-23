abstract class MobileDevice {
    protected String color;
    protected double price;

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

    public abstract boolean isWatch();
}
