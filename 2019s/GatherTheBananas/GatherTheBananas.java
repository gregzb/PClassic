import java.io.*;
import java.util.*;
import java.text.*;

public class GatherTheBananas {
	// do not change the main method
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("GatherTheBananasIN.txt"));
			
			while (br.ready()) {
				int N = Integer.parseInt(br.readLine());
				List<Point> P = new ArrayList<> ();
				for (int j = 0; j < N; j++) {
					String[] line = br.readLine().split(",");
					P.add(new Point(Double.parseDouble(line[0].substring(1)), Double.parseDouble(line[1].substring(1, line[1].length() - 1))));
				}
				double[] ans = makeCircle(P);
				DecimalFormat f = new DecimalFormat("0.###");
				System.out.printf("(%s, %s, %s)\n", new Double(f.format(ans[0])), new Double(f.format(ans[1])), new Double(f.format(ans[2])));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static double[] makeCircle(List<Point> P) {
		return null;
	}
}

class Point {
	double x, y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}