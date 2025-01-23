public class AppleWatch extends MobileDevice {
    private String modelName;
    
    public AppleWatch(String color, double price, String modelName){
        this.color = color;
        this.price = price;
        this.modelName = modelName;
    }
    public void setModelName(String modelName){
        this.modelName = modelName;
    }

    public String getModelName(){
        return modelName;
    }

    public boolean isWatch(){
        return true;
    }

    @Override
    public String toString(){
        return "AppleWatch [color=" + color + ", price=" + price + ", modelName=" + modelName + "]";
    }

}
