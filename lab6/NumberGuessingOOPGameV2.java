import java.util.*;

class GuessGame {
    private int min;
    private int max;
    private int maxTries;
    private int answer;
    private int attempts;
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
                    System.out.println("Congratulations!" + "You have guessed the number in " + attempts +" attempts.");
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

public class NumberGuessingOOPGameV2{
    
    public static Scanner scanner = new Scanner(System.in);
    private GuessGame game;

    public void configure(){
        System.out.println("Enter the min value: ");
        int min = scanner.nextInt();
        System.out.println("Enter the max value: ");
        int max = scanner.nextInt();
        System.out.println("Enter the maximum number of tries: ");
        int maxTries = scanner.nextInt();

        this.game = new GuessGame(min,max,maxTries);
    }

    public void playGames(){
        boolean playAgain;
        do{
            boolean result = this.game.playSingleGame();
            System.out.println(result ? "You win!": "Better luck next time.");
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next().equalsIgnoreCase("y");
            if (playAgain){
                configure();
            }
        } while (playAgain);

        System.out.println("Thank you for playing the Number Guessing Game!");
    }

    public static void main(String[] args){
        NumberGuessingOOPGame program = new NumberGuessingOOPGame();
        program.configure();
        program.playGames();
    }
}
