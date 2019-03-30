import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;



public class TimeTravelTreeTraversal {
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("TimeTravelTreeTraversalIN.txt"));
    while (br.ready()) {
      String[] data = br.readLine().split(" ");
      int m = Integer.parseInt(data[0]);
      int n = 2*m + 1;
      int[][] splits = new int[n][2];
      for (int i = 0; i < n; i++) {
        splits[i][0] = -1;
        splits[i][1] = -1;        
      }
      for (int i = 0; i < m; i++) {
        data = br.readLine().split(" ");
        int k = Integer.parseInt(data[0]);
        splits[k][0] = Integer.parseInt(data[1]);
        splits[k][1] = Integer.parseInt(data[2]);        
      }
      System.out.println(maxDistance(splits));
    }
    br.close();
  }
  private static class Pair {
    public int x, y;
    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  public static int max(int a, int b) {
    if ( a > b ) return a;
    return b;
  }
  public static Pair maxSubDistance(int[][] splits, int root) {
    if (splits[root][0] == -1) {
      return new Pair(1, 0);
    }
    Pair l = maxSubDistance(splits, splits[root][0]);
    Pair r = maxSubDistance(splits, splits[root][1]);
    return new Pair(1 + max(l.x, r.x), max(l.x + r.x, max(l.y, r.y)));
  }
  public static int maxDistance(int[][] splits) {
    return maxSubDistance(splits, 0).y;
  }
}
