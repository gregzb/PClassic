import java.util.*;
import java.io.*;

public class EatingContest {
    // Do not modify below this line
    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("EatingContestIN.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] scoresString = line.split(" ");
            int[] scores = new int[scoresString.length];
            for (int i = 0; i < scoresString.length; i++) {
                scores[i] = Integer.parseInt(scoresString[i]);
            }
            System.out.println(winner(scores));
        }
    }
    // Do not modify above this line
    
    public String winner(int[] scores) {
        return "";
    }
    
    public static void main(String[] args) throws Exception {
        new EatingContest().run();
    }
}




