import java.util.*;
import java.io.*;
public class FastidiousFarming {
    public static void main(String[] args) throws FileNotFoundException {
        // Before submitting, make sure the main method hasn't been changed!
        Scanner sc = new Scanner(new FileReader("FastidiousFarmingIN.txt"));
        while(sc.hasNext()) {
            int[] cropAInputs = new int[2];
            int[] cropBInputs = new int[2];
            int[] allowanceInputs = new int[2];

            String cropALine = sc.nextLine();
            String[] cropAStringInputs = cropALine.split(" ");
            cropAInputs[0] = Integer.parseInt(cropAStringInputs[0]);
            cropAInputs[1] = Integer.parseInt(cropAStringInputs[1]);

            String cropBLine = sc.nextLine();
            String[] cropBStringInputs = cropBLine.split(" ");
            cropBInputs[0] = Integer.parseInt(cropBStringInputs[0]);
            cropBInputs[1] = Integer.parseInt(cropBStringInputs[1]);

            String allowanceLine = sc.nextLine();
            String[] allowanceStringInputs = allowanceLine.split(" ");
            allowanceInputs[0] = Integer.parseInt(allowanceStringInputs[0]);
            allowanceInputs[1] = Integer.parseInt(allowanceStringInputs[1]);

            int[] answer = findCrops(cropAInputs,cropBInputs,allowanceInputs);
            System.out.println(answer[0] + " " + answer[1]);
        }
        sc.close();
    }
     
    public static int[] findCrops(int[] cropAInputs, int[] cropBInputs, int[] allowanceInputs) {

        double aDenom = ((double)cropBInputs[1]*cropAInputs[0]-cropAInputs[1]*cropBInputs[0]);
        if (aDenom == 0) {return new int[]{-1, -1};}
        int aQuant = (int) Math.round(((double)cropBInputs[1]*allowanceInputs[0] - allowanceInputs[1]*cropBInputs[0])
                /aDenom);
        int bQuant;
        if(cropBInputs[0]!= 0) {
        	bQuant = (int) Math.round(((double)allowanceInputs[0]-aQuant*cropAInputs[0])/cropBInputs[0]);	
        } else {
        	bQuant = (int) Math.round(((double)allowanceInputs[1]-aQuant*cropAInputs[1])/cropBInputs[1]);
        }
        if (aQuant < 0 || bQuant < 0) {
        	return new int[]{-1, -1};
        	}
        if ((cropAInputs[0]*aQuant + cropBInputs[0]*bQuant != allowanceInputs[0]) ||
                (cropAInputs[1]*aQuant + cropBInputs[1]*bQuant != allowanceInputs[1])) {
            return new int[]{-1, -1};
        }

        return new int[]{aQuant, bQuant};
   }

}
