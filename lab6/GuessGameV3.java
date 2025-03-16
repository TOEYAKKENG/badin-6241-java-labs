package onchoysakul.badin.lab6;
import java.util.*;
public class GuessGameV3 extends GuessGameV2 {
    //initalize value
    private static final int MAX_GAMES = 100;
    private static GuessGameV3[] gameRecords = new GuessGameV3[MAX_GAMES];
    private static int recordIndex = 0;
    private int[] guesses;
    private int guessCount;
    private boolean win;
    
    static int getMax_GAMES(){
        return MAX_GAMES;
    }

    //default constructor
    public GuessGameV3() {
        super(); //call guessgamev2 constructor
        this.guessCount = 0;
        this.win = false;
    }
    //constructor with parameters
    public GuessGameV3(int min, int max, int maxTries) {
        super(min, max, maxTries); 
        this.guessCount = 0;
        this.win = false;
    }
    @Override
    public void configureGame(int min, int max, int maxTries) {
    setMin(min);
    setMax(max);
    setMaxTries(maxTries);
    this.guessCount = 0;
    this.win = false;
    this.guesses = new int[this.getMaxTries()];
    System.out.println("Game configured with min: " + min + ", max: " + max + ", maxTries: " + maxTries);
    }

    @Override
    public boolean playSingleGame() {
        int guessNumber;
        generateAnswer();
        System.out.println("Welcome to a number guessing game!");
        //loop til max tries
        while (this.guessCount < getMaxTries()) {
            System.out.print("Enter an integer between " + getMin() + " and " + getMax() + ": ");
            guessNumber = scanner.nextInt(); //user input
            this.guesses[this.guessCount++] = guessNumber; //store user input
            if (guessNumber == getAnswer()) {
                System.out.println("Congratulations! You've guessed the number in " + (guessCount) + (guessCount > 1 ? " attempts. " : " attempt. "));
                this.win = true;
                return true;
            } else if (guessNumber < getAnswer()) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }
        }
        System.out.print("Sorry, you've used all your " + (getMaxTries() > 1 ? "attempts." : "attempt."));
        return false;
    }

    public String getGameLog(){
        StringBuilder log = new StringBuilder(); // create a string builder to create a comma-separated string
        for (int i = 0; i < this.guessCount; i++) {
            log.append(guesses[i]);
            if(i < this.guessCount - 1){
                log.append(", ");
            }
        }
        String guessesString = log.toString();
        return String.format("Range: [%d-%d], Max Tries: %d, Attempts: %d, Result: %s, Guesses: %s",this.getMin(),this.getMax(),this.getMaxTries(),this.guessCount,(this.win ? "Win" : "Lose"),guessesString);
    }
    
    public static void addGameRecord(GuessGameV3 game) {
        if (recordIndex < MAX_GAMES) {
            gameRecords[recordIndex] = game;
            recordIndex++;
        } else {
            System.out.println("Game records are full. Cannot add more records.");
        }
    }

    public static GuessGameV3[] getGameRecords() {
        return gameRecords;
    }

    public static int getRecordCount() {
        return recordIndex;
    }

}
