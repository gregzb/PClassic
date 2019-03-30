import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Enigma {
  public static void main(String[] args) throws IOException {
    BufferedReader b = new BufferedReader(new FileReader("EnigmaIN.txt"));
    while (b.ready()) {
      String s1 = b.readLine();
      String s2 = b.readLine();
      System.out.println(first_is_random(s1, s2));
    }
  }
  public static double log_bern_prob(int n, int k) {
    double p = 0;
    for (int i = n - k + 1; i <= n; i++)
      p += Math.log(i);
    for (int i = 1; i <= k; i++)
      p -= Math.log(i);
    p += n*Math.log(0.5);
    return p;
  }
  public static double log_prob(String s) {
    int N = 7;
    double prob = 0;
    for (int i = 0; i + N <= s.length(); i += N) {
      int k = 0;
      for (int j = 0; j < N; j++)
        if (s.charAt(i+j) == '1')
          k++;
      prob += log_bern_prob(N, k);
    }
    return prob;
  }
  //Fill out the body of this method, you should return "nonrandom" if the first string
  //is the non random on and "random" otherwise
  public static String first_is_random(String s1, String s2) {
    //We split each string into substrings of length 7
    //Then we compute the log of the probability under a bernoulli distrobution of all of the
    //substrings occuring
    //Counterintuitively the least probable one is probably the random one since
    //humans tend to think random processes "alternate" more than the actually do
    double prob1 = log_prob(s1);
    double prob2 = log_prob(s2);

    if (prob1 > prob2) {
      return "nonrandom";
    } else {
      return "random";
    }
  }
}
