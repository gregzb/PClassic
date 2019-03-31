import java.io.*;
import java.util.*;

public class RainforestRestaurant {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new FileReader("RainforestRestaurantIN.txt"));

        while (br.ready()) {
            String[] line1 = br.readLine().split(" ");
            String[] line2 = br.readLine().split(" ");
            String[] line3 = br.readLine().split(" ");
            Point entrance = new Point(line1[0], line1[1]);
            Point[] trees = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                trees[i] = new Point(line2[i], line3[i]);
            }
            System.out.println(rainforestRestaurant(entrance, trees));
        }
    }
    // Helper point class
    class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean rainforestRestaurant(Point entrance, Point[] trees) {
        return false;
    }
}