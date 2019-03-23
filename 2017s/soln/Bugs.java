import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;


public class Bugs {
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("BugsIN.txt"));
    while (br.ready()) {
      String[] data = br.readLine().split(" ");
      int N = Integer.parseInt(data[0]);
      int M = Integer.parseInt(data[1]);
      int[][] A = new int[M][2];
      for (int i = 0; i < M; i++) {
        data = br.readLine().split(" ");
        A[i][0] = Integer.parseInt(data[0]);
        A[i][1] = Integer.parseInt(data[1]);
      }
      System.out.println(hasBug(N, M, A));
    }
    br.close();
  }

  public static ArrayList<Integer> dfspreVisit(ArrayList<ArrayList<Integer>> adj,
                                               boolean[] visited, int i,
                                               ArrayList<Integer> L) {
    visited[i] = true;
    for (int j = 0; j < adj.get(i).size(); j++) {
      if (!visited[adj.get(i).get(j)]) {
        dfspreVisit(adj, visited, adj.get(i).get(j), L);
      }
    }
    L.add(0, i);
    return L;
  }
                                               
  public static ArrayList<Integer> dfspre(ArrayList<ArrayList<Integer>> adj) {
    int n = adj.size();
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) visited[i] = false;
    ArrayList<Integer> order = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        order = dfspreVisit(adj, visited, i, order);
      }
    }
    return order;
  }
  public static void dfspreVisit(ArrayList<ArrayList<Integer>> adj,
                                 boolean[] visited, int i,
                                 int[] scc) {
    visited[i] = true;
    for (int j = 0; j < adj.get(i).size(); j++) {
      if (!visited[adj.get(i).get(j)]) {
        scc[adj.get(i).get(j)] = scc[i];
        dfspreVisit(adj, visited, adj.get(i).get(j), scc);
      }
    }
  }
  public static int[] dfstrans(ArrayList<ArrayList<Integer>> adjt,
                               ArrayList<Integer> order) {
    int n = adjt.size();
    int[] scc = new int[n];
    for (int i = 0; i < n; i++) scc[i] = -1;
    int sccnum = 0;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) visited[i] = false;
    for (int i = 0; i < n; i++) {
      if (!visited[order.get(i)]) {
        scc[order.get(i)] = sccnum;
        dfspreVisit(adjt, visited, order.get(i), scc);
        sccnum++;
      }
    }
    return scc;
  }
  public static int[] kosaraju(ArrayList<ArrayList<Integer>> adj) {
    int n = adj.size();
    ArrayList<Integer> order = dfspre(adj);
    ArrayList<ArrayList<Integer>> adjt = new ArrayList<ArrayList<Integer>>(n);
    for (int i = 0; i < n; i++) {
      adjt.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < adj.get(i).size(); j++)  {
        adjt.get(adj.get(i).get(j)).add(i);
      }
    }
    return dfstrans(adjt, order);
  }
  public static boolean hasOddCycleVisit(ArrayList<ArrayList<Integer>> adj,
                                      int[] scc, int i, int[] colors,
                                      boolean[] visited) {
    visited[i] = true;
    //System.out.println("visit: " + i);
    //for (int color : colors) System.out.print(color + " ");
    //System.out.println();
    int otherColor = 0;
    if (colors[i] == 0) otherColor = 1;
    //System.out.println(colors[i] + ", " + otherColor);
    for (int j = 0; j < adj.get(i).size(); j++) {
      //System.out.println(adj.get(i).get(j) + " " + colors[adj.get(i).get(j)]);
      if (scc[i] == scc[adj.get(i).get(j)]) {
        if (colors[i] == colors[adj.get(i).get(j)]) {
          return true;
        }
        if (!visited[adj.get(i).get(j)]) {
          //System.out.println("visiting...");
          colors[adj.get(i).get(j)] = otherColor;
          if (hasOddCycleVisit(adj, scc, adj.get(i).get(j), colors, visited)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  public static boolean hasOddCycle(ArrayList<ArrayList<Integer>> undirected,
                                    int[] scc) {
    int n = undirected.size();
    boolean[] visited = new boolean[n];
    int[] colors = new int[n];
    for (int i = 0; i < n; i++) {
      visited[i] = false;
      colors[i] = -1;
    }
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        colors[i] = 0;
        boolean oddCycle = hasOddCycleVisit(undirected, scc, i, colors, visited);
        if (oddCycle) return true;
      }
    }
    return false;
  }



  public static boolean hasBug(int N, int M, int[][] A) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(N);
    ArrayList<ArrayList<Integer>> undirected = new ArrayList<ArrayList<Integer>>(N);
    for (int i = 0; i < N; i++) {
      adj.add(new ArrayList<Integer>());
      undirected.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < M; i++) {
      adj.get(A[i][0]).add(A[i][1]);
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < adj.get(i).size(); j++) {
        if (!undirected.get(i).contains(adj.get(i).get(j))) {
          undirected.get(i).add(adj.get(i).get(j));
        }
        if (!undirected.get(adj.get(i).get(j)).contains(i)) {
          undirected.get(adj.get(i).get(j)).add(i);
        }
      }
    }
    int[] scc = kosaraju(adj);
    return hasOddCycle(undirected, scc);
  }
}
