import java.util.*;
import java.io.*;


public class DotMatrixChecker {
    public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException
    {
        Scanner sc = new Scanner(new FileReader("DotMatrixCheckerIN.txt"));
        
        while (sc.hasNext()) {
            System.out.println(makeLogo(Integer.parseInt(sc.nextLine())));
        }
        
        
    }
    public static String makeLogo(int n)
    {
        StringBuilder out = new StringBuilder();
        for(int i = 0; i<n; i++)
        {
            if(i==0 || i== n/2)
            {
                for(int j = 0; j < n-1; j++)
                {
                    out.append("X");
                }
                out.append("\n");
            }
            else if(i < n/2)
            {
                out.append("X");
                for(int j = 1; j < n-2; j++)
                {
                    out.append("_");
                }
                out.append("X");
                out.append("\n");
            }
            else
            {
                out.append("X");
                for(int j = 1; j<n-1; j++)
                {
                    out.append("_");
                }
                out.append("\n");
            }
        }
        
        return out.toString(); 
    }
}
