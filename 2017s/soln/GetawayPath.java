import java.util.*; 
import java.io.*; 

public class GetawayPath {
	
	public static int longestPath(int[][] matrix) {
			int result = -1;
			// STUBIFY
			int N = matrix.length;

		    int dp[][] = new int[N][N];
		    Pair lookup[] = new Pair[N*N + 1];
		    for (int i = 0; i < N; i++) {
		    	for (int j = 0; j < N; j++) {
		    		lookup[matrix[i][j]] = new Pair(i, j);
		    	}
		    }

		    int dX[] = {1, 0, -1, 0};
		    int dY[] = {0, 1, 0, -1};

		    for (int i = 0; i < N*N; i++) {
		    	Pair p = lookup[i + 1];
		    	int x = p.i;
		    	int y = p.j;
		    	dp[x][y] = 1;
		    	for (int j = 0; j < 4; j++) {
	    			int nx = x + dX[j];
	    			int ny = y + dY[j];
	    			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
	    				continue;
	    			}
	    			dp[x][y] = Math.max(dp[x][y], dp[nx][ny] + 1);
	    		}
		    }

		    for (int i = 0; i < N; i++) {
		    	for (int j = 0; j < N; j++) {
		    		result = Math.max(dp[i][j], result);
		    	}
		    }

		    // ENDSTUBIFY
		    return result;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("GetawayPathIN.txt"));
		while (sc.hasNext()) {
			int N = sc.nextInt();
			int matrix[][] = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) { 
					matrix[i][j] = sc.nextInt();
				}
			}
			System.out.println(longestPath(matrix));	    
		}
	}

}

class Pair {
	int i;
	int j;
	public Pair(int r, int c) {
		i = r;
		j = c;
	}
}