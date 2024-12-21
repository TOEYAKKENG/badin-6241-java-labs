package onchoysakul.badin.lab5;
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
            boolean continueOperations = true;
            while (continueOperations) {
                displayOperationsMenu();
                System.out.print("Enter your choice: ");
                int operation = scanner.nextInt();
 
 
                switch (operation) {
                    case 1:
                        transposeMatrix(matrix);
                        break;
                    case 2:
                        calculateSums(matrix);
                        break;
                    case 3:
                        findMinMax(matrix);
                        break;
                    case 4:
                        displayDiagonal(matrix);
                        break;
                    case 5:
                        continueOperations = false;
                        continueProgram = false;
                        break;
                    default:
                        System.out.println("Invalid operation choice.");
                }
            }
        }
        scanner.close();
    }
    //just create menu
    public static void displayCreationMenu(){
        System.out.println("\nMaxtrix Creation Menu:" + 
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
    // Part2: Operate
    //operation menu
    public static void displayOperationsMenu(){
        System.out.println("\nMaxtrix Operations Menu:" + 
                            "\n1. Find transpose of the Matrix"+
                            "\n2. Calculate Sum of Row and Columns"+
                            "\n3. Find the Minimum and Maximum Elements" +
                            "\n4. Display Diagonal Elements" +
                            "\n5. Exit");
    }
    // swap row and column
    public static void transposeMatrix(int[][] matrix){
    
        int[][] matrixT = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrixT[j][i] = matrix[i][j];
            }
        }
        System.out.println("\nTransposed Matrix:");
        displayMatrix(matrixT);
    }
    // sum += elements
    public static void calculateSums(int[][] matrix){
        System.out.println("\nRow sum:");
        for (int i = 0; i < matrix.length; i++) {
            int sumrow = 0; //reset row
            for (int j = 0; j < matrix[i].length; j++) {
                sumrow += matrix[i][j];
            }
            System.out.println("Row " + (i+1) + " sum: " + sumrow);
        }

        System.out.println("\nColumn sums:");
        for (int i = 0; i < matrix[0].length; i++) { 
            int sumcolumn = 0; // Reset column
            for (int j = 0; j < matrix.length; j++) { 
                sumcolumn += matrix[j][i];
            }
            System.out.println("Column " + (i + 1) + " sum: " + sumcolumn);
        }
    }
    //add min and max value
    public static void findMinMax(int[][] matrix){
        int min = matrix[0][0];
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min){
                    min = element;
                }    
                if (element > max){
                    max = element;
                }
            }
        }
        System.out.println("\nMinimum element: " + min);
        System.out.println("Maximum element: " + max);
    }
    public static void displayDiagonal(int[][] matrix){
        //row != column
        if (matrix.length != matrix[0].length) { 
            System.out.println("\nMatrix is not square, Cannot display diagonal elemetns.");
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
    }
}