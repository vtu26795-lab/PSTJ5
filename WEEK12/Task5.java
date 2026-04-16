import java.io.*;
import java.util.*;

// Read only region start
class UserMainCode
{

    public int MostFrequentDigit(int input1,int input2,int input3,int input4){
        // Read only region end
        // Write code here...

        int[] freq = new int[10];

        String str = String.valueOf(input1) 
                   + String.valueOf(input2) 
                   + String.valueOf(input3) 
                   + String.valueOf(input4);

        for(int i=0;i<str.length();i++){
            int digit = str.charAt(i) - '0';
            freq[digit]++;
        }

        int max = 0;
        int result = 0;

        for(int i=0;i<10;i++){
            if(freq[i] >= max){
                max = freq[i];
                result = i;
            }
        }

        return result;
    }
}