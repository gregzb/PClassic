import java.util.*;
import java.io.*;
public class ImageLock {
    public static void main(String[] args) throws FileNotFoundException {
        // Before submitting, make sure the main method hasn't been changed!
        Scanner sc = new Scanner(new FileReader("ImageLockIN.txt"));
        while(sc.hasNext()) {
            int width = sc.nextInt();
            int height = sc.nextInt();
            int[][] image = new int[width][height];
            for (int i = 0; i < height; i++) {
              for (int j = 0; j < width; j++) {
                image[j][i] = sc.nextInt();
              }
            }
            if (isCat(image)) {
              System.out.println("cat");
            } else {
              System.out.println("random");
            }
        }
        sc.close();
    }
    
    public static boolean isCat(int[][] image) {
        boolean ans = true;
        //STUBIFY
        int adj = 0;
        double BOUND = 120.0;
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length - 1; j++) {
              adj += Math.abs(image[i][j] - image[i][j + 1]);
            }
        }
        for (int i = 0; i < image.length - 1; i++) {
            for (int j = 0; j < image[0].length; j++) {
              adj += Math.abs(image[i][j] - image[i + 1][j]);
            }
        }
        int dim = image.length * image[0].length;
        double ratio = (double)adj / (double)dim;
        //ENDSTUBIFY
        return ratio < BOUND;
    }
}
