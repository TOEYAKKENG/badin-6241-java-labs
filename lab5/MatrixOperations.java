import java.util.*;
public class MatrixOperations {
    private static int[][] matrix;
    private static int rows;
    private static int columns;
    private static final Scanner scanner = new Scanner(System.in);
 
 
    public static void main(String[] args) {
        boolean continueProgram = true;
        while (continueProgram) {
            displayCreationMenu();
            System.out.println("Enter your choice: ");;
            int choice = scanner.nextInt();
            
 
            if (choice >= 1 && choice <= 4) {
                // For options 1-4, get matrix dimensions
                System.out.print("Enter number of rows: ");
                rows = scanner.nextInt();
                System.out.print("Enter number of columns: ");
                columns = scanner.nextInt();
 
 
                if (rows <= 0 || columns <= 0) {
                    System.out.println("Error: Dimensions must be greater than 0");
                    continue;
                }
 
 
                matrix = new int[rows][columns];
                createMatrix(matrix,choice);
            } else if (choice == 5) {
                // Diagonal matrix must be square
                System.out.print("Enter size of square matrix: ");
                rows = columns = scanner.nextInt();
 
 
                if (rows <= 0) {
                    System.out.println("Error: Size must be greater than 0");
                    continue;
                }
 
 
                matrix = new int[rows][rows];
                createDiagonalMatrix(matrix);
            } else {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }
 
 
            System.out.println("\nCreated Matrix:");
            displayMatrix(matrix);
 
 
            // Operations menu loop
            //boolean continueOperations = true;
            //while (continueOperations) {
            //    displayOperationsMenu();
            //    int operation = scanner.nextInt();
 //
 //
            //    switch (operation) {
            //        case 1:
            //            transposeMatrix();
            //            break;
            //        case 2:
            //            calculateSums();
            //            break;
            //        case 3:
            //            findMinMax();
            //            break;
            //        case 4:
            //            displayDiagonal();
            //            break;
            //        case 5:
            //            continueOperations = false;
            //            continueProgram = false;
            //            break;
            //        default:
            //            System.out.println("Invalid operation choice.");
            //    }
            //}
        }
        scanner.close();
    }
    //just create menu
    public static void displayCreationMenu(){
        System.out.println("Maxtrix Creation Menu:" + 
                            "\n1. User Input Matrix"+
                            "\n2. Random Matrix (0-9)"+
                            "\n3. All zeros Matrix" +
                            "\n4. All ones Matrix" +
                            "\n5. Diagonol Matrix");
    }
    //choice using switch 
    public static void createMatrix(int[][] matrix,int choice){
        switch (choice) {
            case 1:
                manualMatrix(matrix);
                break;
            case 2:
                randomMatrix(matrix);
                break;
            case 3:
                zeroMatrix(matrix);
                break;  
            case 4:
                onesMatrix(matrix);
                break;
        }
    }
 
    //input the matrix element 
    public static void manualMatrix(int[][] matrix){
       System.out.println("Enter matrix elements");
       scanner.nextLine();
       for(int i = 0;i < matrix.length;i++){
           String line = scanner.nextLine();
           //split element
           String[] element = line.split(" ");
           
           for(int j = 0;j < matrix[i].length;j++){
            matrix[i][j] = Integer.parseInt(element[j]);
        }
       }
    }
    //generate random element for matrix 0-9
    public static void randomMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int)(Math.random() * 10);
            }
        }
    }
    //generate all zero matrix
    public static void zeroMatrix(int[][] matrix){
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[i].length;j++){
                matrix[i][j] = 0;
            }
        }
    }
    //generate all one matrix
    public static void onesMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 1;
            }
        }
    }
    // [i]=[j] = 1
    public static void createDiagonalMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
        }
    }
    public static void displayMatrix(int[][] matrix){
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print("  " + element);
            }
            System.out.println();
        }
    }
}