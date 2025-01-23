public class TestAppleWatchNike {
    public static void main(String[] args) {
        AppleWatchNike nikeWatch = new AppleWatchNike("Space Gray", 12900.0, "Nike SE GPS", 42.5, 75,7.5);
        System.out.println(nikeWatch); // display basic information

        //Display health and fitness metrics
        nikeWatch.displayRunningStats();
        nikeWatch.displayHeartRates();
        nikeWatch.displaySleepHours();

        //test inheritance from AppleWatch
        System.out.println("Is this a watch? " + nikeWatch.isWatch()); // Should print true

        //test polymorphism
        AppleWatch baseWatch = nikeWatch; // upcasting
        System.out.println("Through base refernece: " + baseWatch);
    }
    
}
