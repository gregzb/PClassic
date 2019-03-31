import java.util.*;
import java.io.*;

public class RecentlyVegan {
    //Do not modify below this line
     public void run() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("RecentlyVeganIN.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            String[] A = br.readLine().split(", ");
            System.out.println(solve(n, A));
        }
    }
    // Do not modify above this line
     
     public int solve(int n, String[] A) {
         return 0;
     }
     
     public static void main(String[] args) throws Exception {
         new RecentlyVegan().run();
     }
}