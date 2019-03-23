import java.io.File;
import java.io.IOException;
import java.util.Scanner;
 
public class CardinalConfusion {
     
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("CardinalConfusionIN.txt"));
        int counter=0;
        int[] output = new int[25];
        while (sc.hasNextInt() && counter<25) {
            int input=sc.nextInt();
            output[counter]=Solutions(input);
            counter++;        
        }
        for (int i = 0; i < 25; i++) {
            System.out.println(output[i]);
        }
    }
     
    public static int Solutions(int n){
        int count=0;
        int[] counter=new int[n*n+1];
        for(int i=1; i<=n;i++){
            for(int j=1; j<=n;j++){
                counter[i*j]++;
            }
        }
        for(int i=1;i<=n*n;i++){
            count=counter[i]*counter[i-1]+count;
        }
        return count;
         
    }
     
}
