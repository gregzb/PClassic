import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CopsRunIntoEachOther {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("CopsRunIntoEachOtherIN.txt"));
        int[][] input = new int[1][1];
        long[] output = new long[10];
        int counter1 = 2;
        int counter2 = 0;
        int counter3 = 0;
        int width = 0;
        int height = 0;
        while (sc.hasNextInt()) {
            if (counter1 == 2) {
                width = sc.nextInt();
                counter1--;
            } else if (counter1 == 1) {
                height = sc.nextInt();
                counter1--;
                input = new int[width][height];
            } else {
                input[counter2 / height][counter2 % height] = sc.nextInt();
                counter2++;
                if (counter2 == width * height) {
                    output[counter3] = countEvenArrays(input);
                    counter3++;
                    counter1 = 2;
                    counter2 = 0;
                }
            }
        }
        output[counter3] = countEvenArrays(input);
        for (int i = 0; i < 10; i++) {
            System.out.println(output[i]);
        }
    }

    public static long countEvenArrays(int[][] initialArray) {
        int[][] input = new int[initialArray.length + 1][initialArray[0].length + 1];
        for (int i = 1; i < input.length; i++) {
            for (int j = 1; j < input[0].length; j++) {
                input[i][j] = (input[i - 1][j] + input[i][j - 1] + input[i - 1][j - 1] + initialArray[i - 1][j - 1])
                        % 2;
            }
        }
        long count = 0L;
        if (input.length < input[0].length) {
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < i; j++) {
                    int count1 = 0;
                    int count2 = 0;
                    for (int k = 0; k < input[0].length; k++) {
                        if (input[i][k] == input[j][k]) {
                            count1++;
                        } else {
                            count2++;
                        }

                    }
                    count = count + (count1 * (count1 - 1)) / 2 + (count2 * (count2 - 1)) / 2;
                }
            }
        } else {
            for (int i = 0; i < input[0].length; i++) {
                for (int j = 0; j < i; j++) {
                    int count1 = 0;
                    int count2 = 0;
                    for (int k = 0; k < input.length; k++) {
                        if (input[k][i] == input[k][j]) {
                            count1++;
                        } else {
                            count2++;
                        }

                    }
                    count = count + (count1 * (count1 - 1)) / 2 + (count2 * (count2 - 1)) / 2;
                }
            }
        }
        return count;
    }

}
