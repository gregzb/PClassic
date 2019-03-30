import java.util.*;
import java.io.*;

class AthenianVoterFraud {
	public static void main(String[] args)throws IOException {
		
		BufferedReader b = new BufferedReader(new FileReader("AthenianVoterFraudIN.txt"));

		while (b.ready()) {
			String[] data = b.readLine().split(",");
			ArrayList<Integer> votes = new ArrayList<Integer>();
			for (String vote: data) {
				votes.add(Integer.parseInt(vote));
			}
      int[] voters = new int[votes.size()];
      for (int i = 0; i < votes.size(); i++) {
        voters[i] = votes.get(i);
      }
			int[] result = findDuplicates(voters);
      Arrays.sort(result);
			if (result.length == 0) {
				System.out.println("none");
			} else {
				String res = Arrays.toString(result);
				res = res.substring(1, res.length() - 1);
				res = res.replace(", ", ",");
				System.out.println(res);
			}
		}

	}

	public static int[] findDuplicates(int[] voters) {
    int max = -1;
    for (int i = 0; i < voters.length; i++) {
      if (max < voters[i])
        max = voters[i];
    }
    int[] counts = new int[max+1];
    for (int i = 0; i < max+1; i++) {
      counts[i] = 0;
    }
    int num_dupl = 0;
    for (int i = 0; i < voters.length; i++) {
      counts[voters[i]]++;
      if (counts[voters[i]] == 2)
        num_dupl++;
    }
    int[] output = new int[num_dupl];
    int cnt = 0;
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] > 1) {
        output[cnt] = i;
        cnt++;
      }
    }
		return output;
	}
}
