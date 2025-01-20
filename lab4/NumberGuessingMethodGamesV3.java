package onchoysakul.badin.lab4;
import java.util.*;
public class NumberGuessingMethodGamesV3{ 

// configure() -> playGames() -> playGame() ---> logGuess() -->gamelog()
//                                   +                       
//                               getAnswer()               
//
// if quit show stats
    private static int min,max,maxtried,n,guess,round,winround,totalguess,lowestguess;
    private static boolean win; 
    private static Scanner scanner = new Scanner(System.in);
    private static List<Integer> log = new ArrayList<>();
    public static void main(String[] args){
        //for statistic
        round = 0;
        winround = 0;
        totalguess = 0;
        lowestguess = 100; //give max guess = 100
        //___________________________________________
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
        round ++; //round 1++
        log.clear(); // clear data log
        win = false; // reset win
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
                win = true;
                winround ++;
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
    //get the total guess
        totalguess += tried; 
     //get the lowest guess
        if(tried < lowestguess){
            lowestguess = tried;
        }
    //for display the log
        logGuess();
    //show game log
        gameLog();

    }
    static void genAnswer(){
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
                //show statistic
                status();
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
            int getguess = scanner.nextInt();
            if (getguess > 0 && getguess <= log.size()) { //get valid input
                System.out.println("Guess " + getguess + ": " + log.get(getguess - 1));
            } else {
                System.out.println("Invalid guess number.");
            }
        } else {
            break; // Exit the loop if input not a or g
        }
    }
}

    static void status(){
        System.out.println("==== All Game Stats ====");
        System.out.println("Total games played: " + round);
        System.out.println("Total games win: " + winround);
        double winRatio = ((double) winround / round) * 100;
        System.out.println("Win ratio: " + winRatio +"%");
        System.out.println("Average number of guesses per game: " + (double)totalguess/round);
        System.out.println("Highscore (the lowest number of guesses):" + lowestguess );
    }
    static void gameLog(){
        System.out.println("Game log:Answer: " + n +  ", " + 
                        "Guesses: " + log.size() + ", " + 
                        "Win: " + win );
    }
}