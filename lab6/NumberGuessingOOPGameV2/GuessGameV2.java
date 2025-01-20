import java.util.Scanner;

//extend from GuessGame
public class GuessGameV2 extends GuessGame {

    public static Scanner scanner = new Scanner(System.in);
    //set intial value
    public GuessGameV2(){
      setMin(0);
      setMax(100);
      setMaxTries(10);
      setAnswer(0);
      setAttempts(0);
    }

    public GuessGameV2(int min, int max, int maxTries){
        setMin(min);
        setMax(max);
        setMaxTries(maxTries);
        setAnswer(0);
        setAttempts(0);
    }
  
    //overide configureGame
    @Override
    public void configureGame(int min, int max, int maxTries){
    // max > min print error
    while(max < min){
      System.err.println("Invalid input: max must be greater than or equal to min.");
      System.out.print("Enter the min value: ");
      min = scanner.nextInt();
      System.out.print("Enter the max value: ");
      max = scanner.nextInt();
    }
    //max < 1 print error
    while(maxTries < 1){
      System.err.println("Invalid input: maxTries must be greater than 0.");
      System.out.print("Enter the maximum number of tries: ");
      maxTries = scanner.nextInt();
    }
    //pass the value
    setMin(min);
    setMax(max);
    setMaxTries(maxTries);
    setArray(maxTries);
  }
 // overide playsinglegame nothing change much
    @Override
    public boolean playSingleGame(){
    generateAnswer();
    System.out.println("Welcome to a number guessing game!");
    setAttempts(0);
    int min = getMin();
    int max = getMax();
    int attempts = getAttempts();
    int maxTries = getMaxTries();
    int answer = getAnswer();
    int[] guesses = getArray();
    do {
      attempts += 1;
      if(attempts - 1 == maxTries){
        System.out.print("Sorry, you've used all your attempts. The correct answer was: ");
        System.out.println(answer);
        return false;
      }

      System.out.print("Enter an integer between " + min +" and " + max + ": ");
      int guessNumber = scanner.nextInt();

      while(guessNumber > max || guessNumber < min){
        System.err.println("Invalid input: guess must be between " + min + " and " + max);
        System.out.print("Enter an integer between " + min +" and " + max + ": ");
        guessNumber = scanner.nextInt();
      }

      guesses[attempts - 1] = guessNumber;

      if(guessNumber > answer){
        System.out.println("Try a lower number!");
      }
      else if(guessNumber < answer){
        System.out.println("Try a higher number!");
      }
      else{
        System.out.print(guessNumber == answer ? "Congratulations! " : "");
        System.out.print("You've guessed the number in " + attempts);
        System.out.println( attempts == 1 ? " attempt" : " attempts");
        return true;
      }
    }
    while (guesses[attempts - 1] != answer);
        return true;
    }
    // create toString method to show data
    @Override
    public String toString(){
    return "Game Configuration: [Min: " + getMin() + ", Max: " + getMax() + ", Max Tries: " + getMaxTries() + ", Attempts: " + getAttempts() + "]";
  }
}