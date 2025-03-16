package onchoysakul.badin.lab6;
import java.util.Scanner;

public class NumberGuessingOOPGameV3 {

    public static Scanner scanner = new Scanner(System.in);
    private GuessGameV3 game;
    
    public void configure() {
        //get min max and maxTries
        this.game = new GuessGameV3();

        System.out.print("Enter the min value: ");
        int min = scanner.nextInt();
        
        System.out.print("Enter the max value: ");
        int max = scanner.nextInt();
        //check if max is greater than min
        while(max < min){
            System.err.println("Invalid input: max must be greater than or equal to min.");
            
            System.out.print("Enter the min value: ");
            min = scanner.nextInt();
            System.out.print("Enter the max value: ");
            max = scanner.nextInt();
        }
        
        System.out.print("Enter the maximum number of tries: ");
        int maxTries = scanner.nextInt();
        //check  maxtries
        while(maxTries < 1){
            System.err.println("Invalid input: maxTries must be greater than 0.");
            System.out.print("Enter the maximum number of tries: ");
            maxTries = scanner.nextInt();
        }
            
        this.game.configureGame(min, max, maxTries);
        GuessGameV3.addGameRecord(this.game);
            
            
        }
    public void playGames() {        
        int choice;
        this.game.playSingleGame();
        do {
            System.out.println("Do you want to:");
            System.out.println("1. Play again");
            System.out.println("2. View game records");
            System.out.println("3. Quit");
            choice = scanner.nextInt();
        
            switch (choice) {
                case 1:
                    configure();
                    this.game.playSingleGame();
                    break;
                case 2:
                    viewRecords();
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        } while (choice !=3);
        System.out.println("Thank you for playing the Number Guessing Game V3!");
    }

    public void viewRecords() {
        System.out.println("View:");
        System.out.println("1. Complete Record");
        System.out.println("2. Specific Game Record");
        int choice = scanner.nextInt();

        if (choice == 1) { 
            // View all game records
            for (int i = 0; i < GuessGameV3.getRecordCount(); i++) {
                System.out.println("Game " + (i + 1)+ ": " + GuessGameV3.getGameRecords()[i].getGameLog());
            }
        } else if (choice == 2) {
            // View specific game record
            System.out.print("Enter the game number to view: ");
            int gameNumber = scanner.nextInt();
            if (gameNumber > 0 && gameNumber <= GuessGameV3.getRecordCount()) {
                System.out.println("Game " + gameNumber + ": "+ GuessGameV3.getGameRecords()[gameNumber - 1].getGameLog());
            } else {
                System.out.println("Invalid game number.");
            }
        } else {
            System.out.println("Invalid choice.");
            return;
        }
    }
    public static void main(String[] args) {
        NumberGuessingOOPGameV3 program = new NumberGuessingOOPGameV3();
        program.configure();
        program.playGames();
    }
    
    

}