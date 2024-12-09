package onchoysakul.badin.exercises;
public class Avgfinder{
    
    public static void main(String[] args){
        int a = 2,b = 3, c = 4;
        double i = 2.2, j = 3.3;
        System.out.println("The average of " + a + " " + b + " = " + avg(a,b));
        System.out.println("The average of " + a + " " + b + " " + c + " = " + avg(a,b,c));
        System.out.println("The average of " + i + " " + j + " = " + avg(i,j));
    }

static int avg(int a,int b){
    return (a+b)/2;
}
static double avg(int a,int b,int c){
    return (a+b+c)/3.0;
}
static double avg(double i,double j){
    return (i+j)/2;
}
}