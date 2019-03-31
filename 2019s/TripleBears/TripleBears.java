import java.util.*;
import java.io.*;

public class TripleBears {

	public void run() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("TripleBearsIN.txt"));
		int n = Integer.parseInt(br.readLine()); // number of test cases

		for (int i = 0 ; i < n; i++) {
			String[] input = br.readLine().split(" ");
			int[] arr = new int[input.length];

			for (int j = 0; j < input.length; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}

			System.out.println(tripleBears(arr));
		}
	}

	/*public static int tripleBears(int[] arr) {
		int count = 0;
		for (int i = arr.length-1; i>=2; i--) {
			if (arr[i] % 9 == 0) {
				for (int j = 0; j < i; j++) {
					if (arr[j] * 3 == arr[i]) {
						for (int k = 0; k < i; k++) {
							if (arr[k] * 9 == arr[i]) {
								count++;
							}
						}
					}
				}
			}
		}
		return count;
	}*/

	public static int tripleBears(int[] arr) {
		int count=0;
		for (int papa=arr.length-1;papa>=0;papa--){
			for (int mama=0;mama<papa;mama++){
				if (arr[papa]!=0&&arr[mama]!=0&&arr[papa]/3.0==arr[mama]*1.0){
					for (int child=0;child<papa;child++){
						if (arr[child]!=0&&arr[mama]/3.0==arr[child]*1.0){
							count++;
						}
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		//new TripleBears().run();
		int[] y={0,0,3};
		System.out.println(tripleBears(y));
	}
}