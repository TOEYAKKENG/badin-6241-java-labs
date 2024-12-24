package onchoysakul.badin.lab3;
import java.util.*;
public class NumberGuessingGame{ 

/*mini-psudo
  get the random number for guessing
  input the number to guess
  count each time you guess
  print everything
*/

public static void main(String[] args) {
    //starter
    System.out.println("Welcome to a number guessing game!");
    Random random = new Random();
    int n = random.nextInt(1,11);
    int tried = 0;
    //loop guess
     while (tried <= 4) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer between 1 and 10:");
        int guess = scanner.nextInt();
        tried ++;
        if (guess == n) {
            System.out.println("Congratulations!");
            if(tried == 1)
            {
                System.out.println("You have tried 1 time");
            }
            else{
                System.out.println("You have tried " + tried +" times");
            }
            break;
        } else if (guess < n) {
            System.out.println("Try a higher number!");
        } else {
            System.out.println("Try a lower number!");
        }

    if(tried == 5){
        System.out.println("You have tried 5 times. You ran out of guesses");
        System.out.println("The answer is " + n);
    }
    }
}
}