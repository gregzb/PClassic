import java.util.*;
import java.io.*;

public class MakingProfit {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("MakingProfitIN.txt"));
        while(sc.hasNextLine()) {
            int row = Integer.parseInt(sc.nextLine());
            int col = Integer.parseInt(sc.nextLine());
            int[][] matrix = new int[row][col];
            for(int i = 0; i < matrix.length; i++) {
                String line = sc.nextLine();
                String[] elements = line.split(" ");
                for(int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = Integer.parseInt(elements[j]);
                }
            }
            String output = findMaxProfit(matrix);
         System.out.println(output);
        }
        sc.close();
    }
    
    public static String findMaxProfit(int[][] a) {
        String[] days = {
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int max = 0;
        int maxDay = 0;
        for(int i = 0; i < a.length; i++) {
            int sum = 0;
            for(int j = 0; j < a[i].length; j++) {
                sum += a[i][j];
            }
            if(sum > max) {
                max = sum;
                maxDay = i;
            }
        }
        return days[maxDay];
    }
}
