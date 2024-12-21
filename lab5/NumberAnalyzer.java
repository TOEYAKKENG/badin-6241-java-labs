package onchoysakul.badin.lab5;
/**
 * A utility class that provides methods for analyzing arrays of numbers.
 * @author [your name]
 * @version 1.0
 */
import java.util.Arrays;
public class NumberAnalyzer {
	/**
 	* Finds both the minimum and maximum values in an array.
 	* @param numbers the array to analyze
 	* @return an array of two elements where index 0 is minimum and index 1 is maximum
 	*/
	public static int[] findMinMax(int[] numbers) {
    	// Your implementation here
		int min = numbers[0];
		int max = numbers[0];
		for(int i = 0; i< numbers.length;i++){
			if(min >= numbers[i]){
				min = numbers[i];
			}
			if(max <= numbers[i]){
				max = numbers[i];
			}
		}
		return new int[]{min,max};
	}    
	/**
 	* Calculates the running average of numbers up to each position.
 	* For example: input [1,2,3] returns [1.0, 1.5, 2.0]
 	* @param numbers the input array
 	* @return array of running averages
 	*/
	public static double[] calculateRunningAverages(int[] numbers) {
    	// Your implementation here
		double[] avg = new double[numbers.length]; 
		double sum = 0;
		
		for(int count = 0;count < numbers.length;count++){
			sum += numbers[count];
			avg[count] = sum/(count+1);
			System.out.printf("Position %d: %.2f%n", count, avg[count]);
		}
		return avg;
	}
   
	/**
 	* Checks if the array is sorted in ascending order.
 	* @param numbers the array to check
 	* @return true if sorted, false otherwise
 	*/
	public static boolean isSorted(int[] numbers) {
    	// Your implementation here
		int[] sort = Arrays.copyOf(numbers,numbers.length);
		Arrays.sort(sort);
		return Arrays.equals(sort, numbers);
	}
   
	public static void main(String[] args) {
    	// Create example arrays and test method implementations
        int arr[] = {4,2,7,1,9};
        System.out.println("Testing with array: " + Arrays.toString(arr));
        int result[] = findMinMax(arr);
        System.out.println("Minimum of value: " + result[0]);
        System.out.println("Maximum of value: " + result[1]);

		System.out.println("\nRunning in averages:");
		calculateRunningAverages(arr);

		System.out.println("\nTesting if the array are sorted");
		for(int i:arr){
			System.out.print(i+ " ");
		}
		System.out.println("\nnumber1 is sorted: "+isSorted(arr));
	}
}