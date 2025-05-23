package onchoysakul.badin.lab6;
import java.util.*;

public class GuessGame {
    private int min;
    private int max;
    private int maxTries;
    private int answer;
    private int attempts;
    private int[] guesses;
    //constuctor
    public GuessGame() {
        this.min = 1;
        this.max = 100;
        this.maxTries = 10;
        this.answer = 0;
        this.attempts = 0;
    }
    //Constructor Parameters 
    public GuessGame(int min, int max, int maxTries) {
        this.min = min;
        this.max = max;
        this.maxTries = maxTries;
        this.answer = 0;
        this.attempts = 0;
    }

    // Getters and Setters
    //getter
    public int getMin() {
        return min;
    }
    //setter
    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }
    
    public void setAnswer(int answer){
        this.answer = answer;
    }

    public int getAnswer(){
        return answer;
    }
    
    public void setAttempts(int attempts){
        this.attempts = attempts;
    }

    public int getAttempts(){
        return attempts;
    }
    
    public void setArray(int size) {
        guesses = new int[size];
    }
    
    public int[] getArray() {
        return guesses;
    }

    public void configureGame(int min, int max, int maxTries) {
        this.min = min;
        this.max = max;
        this.maxTries = maxTries;
    }

    public void generateAnswer() {
        Random random = new Random();
        this.answer = random.nextInt(max - min + 1) + min;
    }
    
    public boolean playSingleGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to a number guessing game!");
        generateAnswer();
        attempts = 0;
        int guess;
        while(attempts < maxTries){
            while(true){
                System.out.print("Enter an integer between " + min + " and " + max +":");
                guess = scanner.nextInt();
                if(guess < min || guess > max){
                    System.out.println("Enter the integer between " + min + " and " + max);
                }
                else{
                    break;
                }
            }
            attempts++;
                if (guess == answer) {
                    System.out.println("Congratulations! " + "You have guessed the number in " + attempts +" attempts.");
                    return true;
                }   
                else if (guess < answer) {
                    System.out.println("Try a higher number!");
                } 
                else{
                    System.out.println("Try a lower number!");
                }
                
            if (attempts == maxTries) {
                System.out.println("Sorry, You've used all your attempts. The correct answer was: " + answer);
            }
        }
        return false;
    }
}
