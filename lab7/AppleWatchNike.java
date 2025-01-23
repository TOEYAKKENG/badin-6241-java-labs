public class AppleWatchNike extends AppleWatch implements RunnerStatsCollector, HealthMonitorer {
    private double pace;
    private double totalDistance;
    private double time;
    private double avgHeartRate;
    private double maxHeartRate;
    private double avgSleepHours;

    AppleWatchNike(String color, double price, String modelName){
        super(color, price, modelName);
    }

    AppleWatchNike(String color, double price, String modelName , double totalDistance , double avgHeartRate , double avgSleepHours){
        super(color, price, modelName);
        this.totalDistance = totalDistance;
        this.avgHeartRate = avgHeartRate;
        this.avgSleepHours = avgSleepHours;
    }
    //put format
    public void displayRunningStats(){
        System.out.println(String.format("Total distance run: %.2f km", totalDistance));
    }

    public void displayHeartRates(){
        System.out.println("Average heart rate: " + avgHeartRate + " bpm");
    }
    //put format
    public void displaySleepHours(){
        System.out.println(String.format("Average sleep duration: %.2f hours", avgSleepHours));
    }

    @Override
    public String toString(){
        return "AppleWatchNike(color:" + color + ", price:" + price + ", model name:" + modelName + " distance:" + totalDistance + "km" + "]";
    }

}

interface RunnerStatsCollector{
    public void displayRunningStats();
    public void displayHeartRates();
}

interface HealthMonitorer{
    public void displaySleepHours();
}