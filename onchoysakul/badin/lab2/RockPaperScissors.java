// Find the winner of rock paper scissors by player 1 and player 2 get the input from arguments
public class RockPaperScissors {
    public static void main(String[] args) {
        //check arguments
        if (args.length == 2) {
            // get P1 and P2 with using enum Choice also turn it into uppercase
            try{
                Choice P1 = Choice.valueOf(args[0].toUpperCase());
                Choice P2 = Choice.valueOf(args[1].toUpperCase());
                //print what player choose
                System.out.println("Player 1 choose: " + args[0]);
                System.out.println("Player 2 choose: " + args[1]);
                //basic if else
                if ((P1 == Choice.ROCK && P2 == Choice.SCISSORS) ||
                    (P1 == Choice.PAPER && P2 == Choice.ROCK) ||
                    (P1 == Choice.SCISSORS && P2 == Choice.PAPER)){
                        System.out.println("Player 1 wins!");} 
                else if (P1 == P2) {
                        System.out.println("It's a tie!");} 
                else {
                        System.out.println("Player 2 wins!");
                    }
                } 
            //the input is not in Choice
            catch(IllegalArgumentException e) {
                System.err.println("Error: Invalid choice(s). Valid choices are 'rock', 'paper', 'scissors'.");
            }
            }

        else {
            System.err.println("Error: Invalid numbers of arguments. Please provide exactly two arguments");
        }
    }
}

//Last update 26/11/2567