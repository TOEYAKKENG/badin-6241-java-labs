package onchoysakul.badin.lab4;
import java.util.*;
public class NumberGuessingMethodGamesV2{ 

// configure() -> playGames() -> playGame() ---> logGuess()
//                          |                Y               
//                          |--> getAnswer()_|               
//                                                          
    private static int min,max,maxtried,n,guess;
    private static Scanner scanner = new Scanner(System.in);
    private static List<Integer> log = new ArrayList<>(); //list array for correct guess
    public static void main(String[] args){
        configure();
        playGames();
    }

    static void configure(){
        //get min max tries
        System.out.print("Enter the min value:");
        min = scanner.nextInt();
        while(true){
        //check min max error
        System.out.print("Enter the max value:");
        max = scanner.nextInt();
            if(max < min){
                System.out.println("The max value must be at least equal to the min value");
            }
            else{
                break;
            }
        }
        while(true){
         //check tries error
            System.out.print("Enter the maximux of tries:");
            maxtried = scanner.nextInt();
            if(maxtried <= 0){
                System.out.println("The maximum number of tries must be greater than 0");
            }
            else{
                break;
            }
        }
    }
    
    static void playGame(){
        //clear data
        log.clear();
        int tried = 0;
        genAnswer();
        System.out.println("Welcome to a number guessing game!");

        while (tried < maxtried) {
            while(true){
            //check input number error
                System.out.print("Enter an integer between " + min + " and " + max +":");
                guess = scanner.nextInt();
                if(guess < min || guess > max){
                    System.out.println("Enter the integer between " + min + " and " + max);
                }
                else{
                    
                    log.add(guess); //add valid input into array 
                    break;
                }
            }
            tried ++;
            if (guess == n) { //congrat if guess correct continue if not
                System.out.println("Congratulations!");
                if(tried == 1){
                    System.out.println("You have tried 1 time");
                }
                else{
                System.out.println("You have tried " + tried +" times");
                }
                break;
            // higher or lower
            }   
            else if (guess < n) {
                System.out.println("Try a higher number!");
            } 
            else {
                System.out.println("Try a lower number!");
            }
    //run out of tries and give answer
        if (tried == maxtried) {
            System.out.println("You have tried " + tried + " times. You ran out of guesses");
            System.out.println("The answer is " + n);
            }
        }
    //for display the log
        logGuess();

    }
    static void genAnswer(){
        Random r = new Random();
        r.nextInt(min, n);

        n = min + (int)(Math.random() * ((max - min) + 1));
    }
    
    static void playGames(){
        playGame();
        while(true){
            System.out.print("Want to play again (Y or y):");
            if(scanner.next().equalsIgnoreCase("y"))
            {
                playGame();
            }
            else{
                System.out.println("Thank you for playing our games. Bye!");
                break;
            }
        }
    }
    static void logGuess() {
    while (true) {
        System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit: ");
        String choice = scanner.next(); // Read user input

        if (choice.equalsIgnoreCase("a")) { // Compare strings if a/A
            if (log.isEmpty()) {
                System.out.println("No guesses to display.");
            } else {
                for (int i = 0; i < log.size(); i++) {
                    System.out.println("Guess " + (i + 1) + ": " + log.get(i));
                }
            }
        } else if (choice.equalsIgnoreCase("g")) { //compare string if g/G
            System.out.print("Enter the guess number: ");
            int getg = scanner.nextInt();
            if (getg > 0 && getg <= log.size()) { //get valid input
                System.out.println("Guess " + getg + ": " + log.get(getg - 1));
            } else {
                System.out.println("Invalid guess number.");
            }
        } else {
            break; // Exit the loop if input not a or g
        }
    }
}

}