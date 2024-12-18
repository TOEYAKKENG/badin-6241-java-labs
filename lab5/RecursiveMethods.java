
public class RecursiveMethods {
	/**
 	* Recursively finds the sum of digits in a number.
 	* Example: For the number 123, the answer is 1+2+3 = 6
 	* @param number the input number
 	* @return sum of digits
 	*/
	public static int sumOfDigits(int number) {
    // Your implementation here
        if(number == 0){
            return 0;
        }
        return number%10+sumOfDigits(number/10);
        
	}
   
	/**
 	* Recursively reverses an array between start and end indices.
 	* @param arr the array to reverse
 	* @param start starting index
 	* @param end ending index
 	*/
	public static void reverseArray(int[] arr, int start, int end) {
    	// Your implementation here

        if(start >= end){
            return ;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start + 1, end - 1);
        
    }
	/**
 	* Recursively checks if an array is palindrome.
 	* @param arr the array to check
 	* @param start starting index
 	* @param end ending index
 	* @return true if palindrome, false otherwise
 	*/
	public static boolean isPalindrome(int[] arr, int start, int end) {
    	// Your implementation here
        if (start >= end) {
            return true; 
        }
        if (arr[start] != arr[end]) {
            return false; 
        }
        return isPalindrome(arr, start + 1, end - 1); 
    }
	
   
	public static void main(String[] args) {
    	// Demonstrate each recursive method with example input
        int[] arr_st = {1,2,3,4,};
        int[] arr_nd = {1,2,3,4,3,2,1};
        int[] arr_rd = {1,2,1,3};
        int first = 12;
        int two = 23;
        System.out.println("Sum of digit in " + first + ": " + sumOfDigits(first) );
        System.out.println("Sum of digit in " + two + ": " + sumOfDigits(two) + "\n");

        System.out.println("Original array:");
        for(int i = 0;i < arr_st.length;i++)
        {
            System.out.print(arr_st[i] + " ");
        }
        System.out.println("\nReverse array:");
        reverseArray(arr_st,0,arr_st.length-1);
        for(int i = 0;i < arr_st.length;i++)
        {
            System.out.print(arr_st[i] + " ");
        }
        System.out.print("\n");
        System.out.println("\nTesting palindrome");
        for(int i = 0;i < arr_nd.length;i++)
        {
            System.out.print(arr_nd[i] + " ");
        }
        System.out.println("\nIs it true: "+ isPalindrome(arr_nd,0,arr_nd.length-1) + "\n");
        System.out.println("Testing palindrome");
        for(int i = 0;i < arr_rd.length;i++)
        {
            System.out.print(arr_rd[i] + " ");
        }
        System.out.println("\nIs it true: "+ isPalindrome(arr_rd,0,arr_rd.length-1) + "\n");



	}
}
