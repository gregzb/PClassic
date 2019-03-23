import java.util.*;
import java.io.*;

public class SharingSpoils
{
    public static long countWays(int S[], int n)
    {
        long[] table = new long[n+1];
 
        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)
 
        // Base case (If given value is 0)
        table[0] = 1;
 
        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<S.length; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];
 
        return table[n];
    }
 
    public static void main(String args[]) throws FileNotFoundException
    {
    	Scanner sc = new Scanner(new FileReader("SharingSpoilsIN.txt"));
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[] = new int[m];
            for (int i = 0; i < m; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(countWays(arr, n));
        }
    }
}