import java.util.*;
import java.io.*;
public class LaserBeamVault {
    public static void main(String[] args) throws FileNotFoundException {
        // Before submitting, make sure the main method hasn't been changed!
        Scanner sc = new Scanner(new FileReader("LaserBeamVaultIN.txt"));
        while(sc.hasNext()) {
            int N = sc.nextInt();
            int[] xCoords = new int[N];
            int[] yCoords = new int[N];
            for (int i = 0; i < N; i++) {
              xCoords[i] = sc.nextInt();
              yCoords[i] = sc.nextInt();
            }
            System.out.printf("%d\n", countParallelograms(xCoords, yCoords));
        }
        sc.close();
    }

    private static class Pair {
      int _x;
      int _y;
      Pair(int x, int y) {
        this._x = x;
        this._y = y;
      }
      public boolean equals(Object o) {
        if (o instanceof Pair) {
          Pair p = (Pair) o;
          return (p._x == this._x && p._y == this._y);
        }
        return false;
      }
      public int hashCode() {
        return this._x * 31 + this._y;
      }
    }
     
    public static int countParallelograms(int[] xCoords, int[] yCoords) {
        int parallelograms = 0;
        //STUBIFY
        int N = xCoords.length;
        HashMap<Pair, Integer> midpoints = new HashMap<Pair, Integer>();
        for (int i = 0; i < N; i++) {
          for (int j = i + 1; j < N; j++) {
            Pair midpoint = new Pair(xCoords[i] + xCoords[j], yCoords[i] + yCoords[j]);
            if (midpoints.containsKey(midpoint)) {
              parallelograms += midpoints.get(midpoint);
              midpoints.put(midpoint, midpoints.get(midpoint) + 1);
            } else {
              midpoints.put(midpoint, 1);
            }
          }
        }
        //ENDSTUBIFY
        return parallelograms;
    }
}
