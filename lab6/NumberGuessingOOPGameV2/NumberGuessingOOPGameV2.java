package onchoysakul.badin.lab6;
import java.util.Scanner;

public class NumberGuessingOOPGameV2 {

  public static Scanner scanner = new Scanner(System.in);

  private GuessGameV2 game;
  
  public void configure(){
    this.game = new GuessGameV2();
    System.out.print("Enter the min value: ");
    int min = scanner.nextInt();
    this.game.setMin(min);

    System.out.print("Enter the max value: ");
    int max = scanner.nextInt();
    this.game.setMax(max);

    this.game.configureGame(this.game.getMin(), this.game.getMax(), this.game.getMaxTries());
    System.out.print("Enter the maximum number of tries: ");
    int maxTries = scanner.nextInt();
    this.game.setMaxTries(maxTries);
    this.game.configureGame(this.game.getMin(), this.game.getMax(), this.game.getMaxTries());
    System.out.println(this.game.toString());
  }

  public void playGames() {
    boolean playAgain;
    do {
      boolean result = this.game.playSingleGame();
      System.out.println(result ? "You win!" : "Better luck next time.");
      System.out.print("Do you want to play again? (y/n): ");
      playAgain = scanner.next().equalsIgnoreCase("y");
      if(playAgain){
        configure();
      }
    } while (playAgain);

    System.out.println("Thank you for playing the Number Guessing Game!");
  }
    public static void main(String[] args){
        NumberGuessingOOPGameV2 program = new NumberGuessingOOPGameV2();
        program.configure();
        program.playGames();
        scanner.close();
    }

}