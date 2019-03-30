import java.util.*;
import java.io.*;
public class Tricky {
    public static void main(String[] args) throws FileNotFoundException {
        // Before submitting, make sure the main method hasn't been changed!
        Scanner sc = new Scanner(new FileReader("TrickyIN.txt"));
        while(sc.hasNext()) {
            int length = sc.nextInt();
            Iterable<Integer> output = findTriples(length);
            String s = "[";
            boolean isFirstElement = true;
            for(Integer i : output) {
                if(isFirstElement) {
                    s += i;
                    isFirstElement = false;
                }
                else {
                    s += ", "+ i;
                }
            }
            s += "]";
            System.out.println(s);   
        }
        sc.close();
    }
    
    public static Iterable<Integer> findTriples(int hypotenuse) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        int c_2 = hypotenuse * hypotenuse;
        for(int a = 1; a < hypotenuse; a++) {
            int a_2 = a * a;
            for(int b = 1; b < hypotenuse; b++) {
               int b_2 = b * b;
               if(a_2 + b_2 == c_2) {
                   output.add(a);
                   output.add(b);
               }
            }
        }
        return output;
    }
}
