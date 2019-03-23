import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;



public class PoorPour {
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("PoorPourIN.txt"));
    while (br.ready()) {
      String[] data = br.readLine().split(" ");
      int n = data.length;
      int[] heights = new int[n];
      for (int i = 0; i < n; i++) {
        heights[i] = Integer.parseInt(data[i]);
      }
    
      System.out.println(volume(heights));
    }
    br.close();
  }

  public static int volume(int[] heights) {
    int n = heights.length;
    int[] preMaxs = new int[n-1];
    int[] postMaxs = new int[n-1];
    preMaxs[0] = heights[0];
    postMaxs[n-2] = heights[n-1];
    for (int i = 1; i < n-1; i++) {
      preMaxs[i] = Math.max(preMaxs[i-1], heights[i]);
      postMaxs[n-2-i] = Math.max(postMaxs[n-2-i+1], heights[n-1-i]);
    }

    int V = 0;
    for (int i = 0; i < n-1; i++) {
      int fill_height = Math.min(preMaxs[i], postMaxs[i]);
      V += 5*fill_height;
      if (i < n-2)
        V += Math.max(fill_height-heights[i+1], 0);
    }
    return V;
  }
}
