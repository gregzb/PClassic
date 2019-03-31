import java.util.*;
import java.io.*;

public class BalancedDiet {

	public void run() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("BalancedDietIN.txt"));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			System.out.println(isBalanced(s) ? "True" : "False");
		}
	}

	public static boolean isBalanced(String input) {
		return false;
	}

	public static void main(String[] args) throws Exception {
		new BalancedDiet().run();
	}
}