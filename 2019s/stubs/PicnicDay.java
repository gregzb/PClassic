import java.io.BufferedReader;
import java.io.FileReader;
 
public class PicnicDay {
    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("PicnicDayIN.txt"));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            int nodes = Integer.parseInt(br.readLine());
            int[][] edges = new int[nodes - 1][2];
            for (int j = 0; j < nodes - 1; ++j) {
                String[] edge = br.readLine().split(" ");
                edges[j][0] = Integer.parseInt(edge[0]);
                edges[j][1] = Integer.parseInt(edge[1]);
            }
            System.out.println(minDishes(nodes, edges));
        }
        br.close();
    }
 
    public int minDishes(int n, int[][] edges) {
        return 0;
    }
 
    public static void main(String[] args) throws Exception {
        new PicnicDay().run();
    }
}