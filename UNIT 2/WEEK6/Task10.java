import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'circularPalindromes' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING s as parameter.
     */

    public static List<Integer> circularPalindromes(String s) {
        int n = s.length();
        String doubled = s + s;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int max = longestPalindrome(doubled, i, i + n - 1);
            result.add(max);
        }

        return result;
    }

    private static int longestPalindrome(String s, int left, int right) {
        int max = 1;

        for (int i = left; i <= right; i++) {

            // odd length
            int l = i, r = i;
            while (l >= left && r <= right && s.charAt(l) == s.charAt(r)) {
                max = Math.max(max, r - l + 1);
                l--;
                r++;
            }

            // even length
            l = i;
            r = i + 1;
            while (l >= left && r <= right && s.charAt(l) == s.charAt(r)) {
                max = Math.max(max, r - l + 1);
                l--;
                r++;
            }
        }

        return max;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        List<Integer> result = Result.circularPalindromes(s);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
