import java.io.*;
import java.util.*;

public class ExoticOrchard {
	// do not change main method
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("ExoticOrchardIN.txt"));
			int N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {
				String[] line = br.readLine().split(",");
				Point newPoint = new Point(Integer.parseInt(line[0].substring(1)),
						Integer.parseInt(line[1].substring(1, line[1].length() - 1)));
				int K = Integer.parseInt(br.readLine());
				Point[] P = new Point[K];
				for (int j = 0; j < K; j++) {
					line = br.readLine().split(",");
					P[j] = new Point(Integer.parseInt(line[0].substring(1)),
							Integer.parseInt(line[1].substring(1, line[1].length() - 1)));
				}
				System.out.println(in_perimeter(P, newPoint) ? "1" : "0");
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static boolean in_perimeter(Point[] points, Point newPoint) {
		return false;
	}
}