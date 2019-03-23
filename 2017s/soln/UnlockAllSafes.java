import java.util.*;
import java.io.*;

public class UnlockAllSafes {
    
    public static int[] spiralOrder(int[][] matrix) {
        int[] result = new int[matrix.length * matrix.length];
        // STUBIFY
        if(matrix == null || matrix.length == 0) return result;
 
        int m = matrix.length;
        int n = matrix[0].length;
 
        int x=0; 
        int y=0;
        int p=0;
 
        while(m>0 && n>0){
 
            //if one row/column left, no circle can be formed
            if(m==1){
                for(int i=0; i<n; i++){
                    result[p++] = matrix[x][y++];
                }
                break;
            }else if(n==1){
                for(int i=0; i<m; i++){
                    result[p++] = (matrix[x++][y]);
                }
                break;
            }
 
            //below, process a circle
 
            //top - move right
            for(int i=0;i<n-1;i++){
                result[p++] = (matrix[x][y++]);
            }
 
            //right - move down
            for(int i=0;i<m-1;i++){
                result[p++] = (matrix[x++][y]);
            }
 
            //bottom - move left
            for(int i=0;i<n-1;i++){
                result[p++] = (matrix[x][y--]);
            }
 
            //left - move up
            for(int i=0;i<m-1;i++){
                result[p++] = (matrix[x--][y]);
            }
 
            x++;
            y++;
            m=m-2;
            n=n-2;
        }
        // ENDSTUBIFY
        return result;
    }

    // Do not modify main code
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("UnlockAllSafesIN.txt"));
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int[] result = spiralOrder(matrix);
            for (int i = 0; i < result.length - 1; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.print(result[result.length - 1]);
            System.out.println();
        }
    }

}