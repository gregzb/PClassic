import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Treasons
{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("TreasonsIN.txt"));
        int i=0;
        String[] input=new String[10000];
        while (sc.hasNext()) {
            input[i]=sc.next();
            i++;    
        }
        int counter=0;
        String[] input2=new String[i];
        while (counter<i){
            input2[counter]=input[counter];
            counter++;}
        String[] input20=new String[20];
        int counter2=0;
        for (int j=0; j<i;j++){
            if (!(input2[j].equals("|"))){
                input20[counter2]=input2[j];
                counter2++;
            }
            else{
                counter2=0;
                System.out.println(Arrays.toString(maximalAnagramList(input20)));
            }
        }
        sc.close();
    }

    public static boolean isAnagram(String firstWord, String secondWord) {
        char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
        char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);
        return Arrays.equals(word1, word2);
    }

    public static String[] maximalAnagramList(String[] array) {
        int max = 0;
        String key="";
        for (int i=array.length-1; i>=0 ; i--){
            int counter=0;
            for (int j=0; j<i; j++){
                if (isAnagram (array[i],array[j])){
                    counter++;
                }
            }
            if (counter>max) {
                max=counter;
                key=array[i];
            }
        }
        String[] output=new String[max+1];
        int counter2=0;
        for (int i=0;i<array.length;i++){
            if (isAnagram (array[i], key)){
                output[counter2]=array[i];
                counter2++;
            }
        }
        Arrays.sort(output);
        return output;
    }
}

