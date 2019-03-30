import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class NewtonsNightmare {

    public static void main(String[] args) throws FileNotFoundException {
        // Before submitting, make sure the main method hasn't been changed!
        Scanner sc = new Scanner(new FileReader("NewtonsNightmareIN.txt"));
        while(sc.hasNext()) {
            String[] firstLine = sc.nextLine().split(" ");
            int numLines = Integer.parseInt(firstLine[0]);
            double targetX = Double.parseDouble(firstLine[1]);
            
            int[] heights = new int[numLines];
            double[] indexes = new double[numLines];
            
            for(int i = 0; i < numLines; i++) {
            	String[] curLine = sc.nextLine().split(" ");
            	heights[i] = Integer.parseInt(curLine[0]);
            	indexes[i] = Double.parseDouble(curLine[1]);
            }
            
            System.out.printf("%.4f\n", findAngle(heights, indexes, targetX));
        }
        sc.close();
    }
    
    private static double findAngle(int[] heights, double[] indexes, double targetX) {
    	double angle = 0.0;
    	double l = Math.PI * 0.5;
    	double r = 0.0;
    	double maxError = .000000001;
    	while (Math.abs(l - r) > maxError) {
    		angle = 0.5 * (l + r);
    		double incidenceAngle = 0.5 * Math.PI - angle;
    		double prevIndex = indexes[0];
    		double x = Math.tan(incidenceAngle) * (double)heights[0];
    		boolean otherCondition = false;
    		for (int i = 1; i < heights.length; i++) {
    			double sinAngle = Math.sin(incidenceAngle) * prevIndex / indexes[i];
    			if ((sinAngle > 1) || (sinAngle < 0)) {
    				r = angle;
    				otherCondition = true;
    				break;
    			}
    			incidenceAngle = Math.asin(sinAngle);
    			prevIndex = indexes[i];
    			x += Math.tan(incidenceAngle) * (double)heights[i];
    		}
    		if (!otherCondition) {
    			if (x > targetX) {
    				r = angle;
    			} else {
    				l = angle;
    			}
    		}
    	}
    	angle = angle * (180.0 / Math.PI);
    	return Math.round(angle * 10000.0)/10000.0;
    	
    }
}
