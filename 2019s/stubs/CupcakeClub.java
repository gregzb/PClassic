import java.util.*;
import java.io.*;
import java.math.*;

public class CupcakeClub {
	public void run() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("CupcakeClubIN.txt"));
		int n = Integer.parseInt(br.readLine());
	    while (n-->0) {
	        String[] sa = br.readLine().split(" ");
	        System.out.println(solve(sa[0],sa[1]));
	    }
	}
	
	public int solve(String message1, String message2) {
		return 0;
	}
	
	public static void main (String[] args) throws Exception {
		new CupcakeClub().run();
	}
}
