import java.io.*;
import java.util.*;

public class HellsImmigration {
    // do not change anything in main method
    public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("HellsImmigrationIN.txt"));
			int testCases = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < testCases; i++) {
                String[] line = br.readLine().split(" ");
                int N = Integer.parseInt(line[0]);
                int M = Integer.parseInt(line[1]);

                List<Shift> shift = new ArrayList<> ();
				for (int j = 0; j < N; j++) {
                    line = br.readLine().split(" ");
                    shift.add(new Shift(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
                }
                List<Edge> edges = new ArrayList<> ();
                for (int j = 0; j < M; j++) {
                    line = br.readLine().split(" ");
                    edges.add(new Edge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2])));
                }
                line = br.readLine().split(" ");
                int s = Integer.parseInt(line[0]);
                int d = Integer.parseInt(line[1]);
				System.out.println(helpRordon(N, M, shift, edges, s, d));
            }
            br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public static int helpRordon(int n, int m, List<Shift> shift, List<Edge> edges, int s, int d) {
       return -1;
    }

    static class Shift {
        public int first;
        public int second;

        public Shift(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Edge {
        public int u;
        public int v;
        public int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
}