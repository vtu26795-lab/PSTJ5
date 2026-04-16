import java.io.*;
import java.util.*;

class UserMainCode {

    public int mostFrequentlyOccurringDigit(int[] input1, int input2) {

        int[] freq = new int[10]; // digits 0-9

        // Count frequency of each digit
        for (int i = 0; i < input2; i++) {
            int num = input1[i];

            // Handle 0 separately
            if (num == 0) {
                freq[0]++;
            }

            while (num > 0) {
                int digit = num % 10;
                freq[digit]++;
                num = num / 10;
            }
        }

        // Find max frequency
        int maxFreq = -1;
        int result = -1;

        for (int i = 0; i < 10; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                result = i;
            } 
            // If tie → choose larger digit
            else if (freq[i] == maxFreq && i > result) {
                result = i;
            }
        }

        return result;
    }
}