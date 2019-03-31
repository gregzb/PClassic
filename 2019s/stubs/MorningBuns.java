import java.util.*;
import java.io.*;
import java.math.*;

public class MorningBuns {
	public void run() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("MorningBunsIN.txt"));
		int n = Integer.parseInt(br.readLine());
	    while (n-->0) {
	        int s = Integer.parseInt(br.readLine());
	        char[][] cm = new char[s][s];
		    for (int r = 0; r < s; r++) {
		        cm[r] = br.readLine().toCharArray();
		    }
		    System.out.println(message_reveal(cm));
	    }
	}

	public String message_reveal(char[][] matrix) {
		return "";
	}

	public static void main (String[] args) throws Exception {
		new MorningBuns().run();
	}
}
