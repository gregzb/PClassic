import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Treasure {

	public static void main(String[] args) throws FileNotFoundException {
		
		 Scanner fileInput = new Scanner(new File("TreasureIN.txt"));
        
	     while(fileInput.hasNext()) {
	        	
	         int length = fileInput.nextInt();
	         int width = fileInput.nextInt();
	         int height = fileInput.nextInt();
	           
	         System.out.println(getGold(length, width, height));
	             
	     }
	  
	     fileInput.close();
		
	}
	
	public static int getGold(int length, int width, int height) {
		return length*width*height;
	}
	
}
