import java.util.Comparator;
import java .util.Arrays;
//Comparator implementation for sorting MobileDevices by price
public class SortMobileDevicesbyPrice implements Comparator<MobileDevice> {
    public static void main(String[] args) {
        //Create array of mobile devices

        MobileDevice[] devices = new MobileDevice[4];
        devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
        devices[1] = new IPadAir("Silver", 24900.0, 256);
        devices[2] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        devices[3] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");
        
        //Sort the devices by price using our comparator
        Arrays.sort(devices, new SortMobileDevicesbyPrice());

        //Display sorted devices
        System.out.println("Mobile devices sorted by price");
        for (MobileDevice device : devices) {
            System.out.println(device);
        }
    }
    /////////
    @Override
    public int compare(MobileDevice o1, MobileDevice o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
    ////////
}


