import java.util.*;
import java.io.*;
import java.math.*;

public class WaitressDilemma {
    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("WaitressDilemmaIN.txt"));
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            int n = Integer.parseInt(br.readLine());
            String[] s1 = br.readLine().split(" ");
            String[] s2 = br.readLine().split(" ");
            System.out.println(minBridges(n,Integer.parseInt(s1[0]),Integer.parseInt(s1[1]),Integer.parseInt(s2[0]),Integer.parseInt(s2[1])));
        }
    }
    
    public int minBridges(int n, int xs, int ys, int xd, int yd) {
        return 0;
    }
    
    public static void main (String[] args) throws Exception {
        new WaitressDilemma().run();
    }
}
