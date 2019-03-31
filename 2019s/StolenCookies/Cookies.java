import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cookies {
	// Before submitting, make sure the main method hasn't been changed!
    // DO NOT MODIFY BELOW THIS LINE

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("CookiesIN.txt"));
        String[] data = br.readLine().split(" ");
        int testCases = Integer.parseInt(data[0]);
        for( ; testCases > 0; testCases--) {
        	System.out.println( solve( br.readLine() ) );
        }
        br.close();
    }

    // DO NOT MODIFY ABOVE THIS LINE


    // Fill out the body of this method
    public static int solve(String str) {
        return 0;
    }
}
