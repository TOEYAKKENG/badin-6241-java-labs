package onchoysakul.badin.lab3;
import java.util.*;
public class ConfigurableNumberGuessingGame{ 

/*mini-psudo
  get the random number for guessing 
  input the number to guess
  count each time you guess
  print everything
  __________________________________
  get min max maxtries for input
  use while loop to check all error on min max try and break if done
*/

public static void main(String[] args) {
    //starter value
    System.out.println("Welcome to a number guessing game!");
    int min,max,maxtried,guess;
    int tried = 0;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the min value:");
    min = scanner.nextInt();
    //input min max tries
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
    //random
    int n = random.nextInt(min,max);

    //loop guess
     while (tried < maxtried) {
        while(true){
        //check input number error
            System.out.print("Enter an integer between " + min + " and " + max +":");
            guess = scanner.nextInt();
            if(guess < min || guess > max){
                System.out.println("Enter the integer between " + min + " and " + max);
            }
            else{
                break;
            }
        }
        tried ++;
        if (guess == n) { //congrat if guess correct continue if not
            System.out.println("Congratulations!");
            if(tried == 1)
            {
                System.out.println("You have tried 1 time");
            }
            else{
                System.out.println("You have tried " + tried +" times");
            }
            break;
            // higher or lower
        } else if (guess < n) {
            System.out.println("Try a higher number!");
        } else {
            System.out.println("Try a lower number!");
        }
    //run out of tries and give answer
    if (tried == maxtried) {
        System.out.println("You have tried " + tried + " times. You ran out of guesses");
        System.out.println("The answer is " + n);
        }
    }
}
}