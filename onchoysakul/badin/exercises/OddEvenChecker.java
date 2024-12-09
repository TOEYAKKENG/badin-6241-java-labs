package onchoysakul.badin.exercises;
public class OddEvenChecker {
    public static void main(String[] args) {
        if(args.length != 1){
            System.exit(1);
        }
        int n = Integer.parseInt(args[0]);

        if(n%2 == 0){
            System.out.println(n + " is even");
        }
        else{
            System.out.println(n + " is odd");
        }

    }
}
