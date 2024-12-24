import java.util.Arrays;
public class multiarr{
    public static void main(String[] args) {
        int [][] multiArr ={ {1,8,7,2},
                            {5,3},
                            {3,2,6} };
        Arrays.sort(multiArr[0]);
        Arrays.sort(multiArr[1]);
        Arrays.fill(multiArr[2],3);


    
    for(int i =0;i< multiArr.length;i++){
        for (int j = 0; j < multiArr[i].length;j++){
            System.out.print(multiArr[i][j] + " ");
        }
        System.out.println();
    }
}   
}