import java.util.*;
import java.io.*;

public class TripleBears {

	public void run() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("TripleBearsIN.txt"));
		int n = Integer.parseInt(br.readLine()); // number of test cases

		for (int i = 0 ; i < n; i++) {
			String[] input = br.readLine().split(" ");
			int[] arr = new int[input.length];

			for (int j = 0; j < input.length; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}

			System.out.println(tripleBears(arr));
		}
	}

	public static int tripleBears(int[] arr) {
		return 0;
	}

	public static void main(String[] args) throws Exception {
		new TripleBears().run();
	}
}