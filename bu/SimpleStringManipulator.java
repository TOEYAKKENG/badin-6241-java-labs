   /* Badin Onchoysakul
       673040624-1
       "This program is all about declare and assing the variable"
       26/11/2567
    */
public class SimpleStringManipulator {
    public static void main(String[] args) {
        // take 2 arguments and print the first two line
        if (args.length == 2) {
            System.out.println("First String: " + args[0]);
            System.out.println("Second String: " + args[1]);
            //Get the first character from string using charAt()
            String first = args[0];
            String second = args[1];
            char first_character = first.charAt(0);
            char last_character = second.charAt(second.length()-1);
            //Check if the first charater is aeiou if True turn it into uppercase using toUppercase
            //and if the last character isnt aeious if true turn it into uppercase using toUppercase
            if (first_character == 'a' || first_character == 'e' || 
                first_character == 'i' || first_character == 'o' || 
                first_character == 'u') {
                first_character = Character.toUpperCase(first_character);
            }
            if (last_character != 'a' && last_character != 'e' && 
                last_character != 'i' && last_character != 'o' && 
                last_character != 'u') {
                last_character = Character.toUpperCase(last_character);
            }
            
            
            //renew the first string and second string by merge the new character and the rest 
            first = first_character + first.substring(1);
            second = second.substring(0, second.length() - 1) + last_character;
            // print result
            System.out.println("Resulting String: " + first + second);
        }
        // Invalid input
        else {
            System.err.println("Error: Invalid number of arguments. Please provide exactly two strings as arguments");
        }
    }
}