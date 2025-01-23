import java.util.Comparator;
import java.util.Arrays;

public class SortMobileDevices implements Comparator<MobileDevice>{
    public  static void main(String[] args){
        // Create array of mobile devices with test cases
       MobileDevice[] devices = new MobileDevice[7];
       devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
       devices[1] = new IPadAir("Silver", 24900.0, 256);
       // Same price, different storage
       devices[2] = new IPadAir("Space Gray", 19900.0, 128);
       devices[3] = new IPadAir("Silver", 19900.0, 64);
       // AppleWatches with different prices
       devices[4] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
       // Same price, different models
       devices[5] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");
       devices[6] = new AppleWatch("Gold", 12900.0, "Apple Watch Series 7");
       // Sort the device using our comparator
       Arrays.sort(devices, new SortMobileDevices());

       // Display sorted devices
       System.out.println("Mobile devices sorted by multiple criteria");
       for(MobileDevice device : devices){
           System.out.println(device);
       }
    }
    //if price = -> model if diffennt types -> compare color
    //if same model (ipad) -> compare storage -> color
    //if same model (applewatch) -> compare model name -> color
    @Override
    public int compare(MobileDevice o1, MobileDevice o2){
        // Compare prices
        int priceComparison = Double.compare(o1.getPrice(), o2.getPrice());
        if(priceComparison != 0){
            return priceComparison;
        }
        // Compare models
        //if both are IPadAir
        if(o1 instanceof IPadAir && o2 instanceof IPadAir){
            //compare storage
            int storageComparison = Double.compare(((IPadAir)o1).getStorage(), ((IPadAir)o2).getStorage());
            if(storageComparison != 0){
                return storageComparison;
            }
            return o1.getColor().compareTo(o2.getColor()); //compare color
        
        //if both are AppleWatch
        }else if(o1 instanceof AppleWatch && o2 instanceof AppleWatch){
            //compare model name
            int modelComparison = ((AppleWatch)o1).getModelName().compareTo(((AppleWatch)o2).getModelName());
            if(modelComparison != 0){
                return modelComparison;
            }
            return o1.getColor().compareTo(o2.getColor()); //compare color
        }
        // Compare colors if different models
        return o1.getColor().compareTo(o2.getColor());
    }
}