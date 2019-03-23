import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SecurityAnalysis {

	public static void main(String[] args) throws FileNotFoundException {
		
		 Scanner fileInput = new Scanner(new File("SecurityAnalysisIN.txt"));
        
	        while(fileInput.hasNext()) {
	        	
	            String letter = fileInput.nextLine();
	            String string1 = fileInput.nextLine();
	            String string2 = fileInput.nextLine();
	            
	            System.out.println(modifiedLcs(letter, string1, string2));
	             
	        }
	        fileInput.close();
	}
	
	public static String modifiedLcs(String letter, String string1, String string2) {
		
		String lcs = "";
		
		for(int i = 0; i < string1.length(); i++) {
			if(string1.substring(i, i + 1).equals(letter)) {
				for(int j = 0; j < string2.length(); j++) {
					if(string2.substring(j, j + 1).equals(letter)) {
						int k = 0;
						while(i + k < string1.length() && j + k < string2.length()) {
							if(string1.substring(i + k, i + k + 1).equals(string2.substring(j + k, j + k + 1))) {
								if(k + 1 > lcs.length()) {
									lcs = string1.substring(i, i + k + 1);
								}
								k++;
							} else {
								k = string1.length();
							}
						}
					}
				}
			}
		}
		
		return lcs;
	}
	
}
